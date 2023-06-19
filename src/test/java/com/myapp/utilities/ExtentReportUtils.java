package com.myapp.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.myapp.utilities.MediaUtils.takeScreenshotOfTheEntirePageAsString;

public class ExtentReportUtils {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    static {
        //        WHAT WILL BE REPORT NAME AND WHERE THE REPORT IS CREATED
//        PATH
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent_reports.html";
//        Create the HTML template using extent html reporter in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        Create extent report
        extentReports = new ExtentReports();
//        ***********ADDING CUSTOM SYSTEM INFORMATION ***********
        extentReports.setSystemInfo("Application Name","Apple M1 Unit");
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","Andrey");
        extentReports.setSystemInfo("Feature Number","FE1056");
//        ***********DOCUMENT INFORMATION************************
        extentHtmlReporter.config().setReportName("My Regression Report");
        extentHtmlReporter.config().setDocumentTitle("My Regression Extent Reports");
//        ***********DONE WITH CONFIGURATIONS********************
//        connecting extent reports and extent html reporter
        extentReports.attachReporter(extentHtmlReporter);
//        **********CREATE EXTENT TEST THAT IS ALSO KNOWN AS LOGGER**
        extentTest=extentReports.createTest("MY REGRESSION","MY FIRST EXTENT REPORT");
    }
//LOGGER METHODS
    //ExtentReportUtils.pass("message")--> marks the log as pass and shows the message on the report
public static void pass(String message){
        extentTest.log(Status.PASS,message);
}

    //ExtentReportUtils.info("message")--> marks the log as INFO  and shows the message on the report
    public static void info(String message){
        extentTest.log(Status.INFO,message);
    }

    //ExtentReportUtils.fail("message")--> marks the log as FAIL and shows the message on the report
    public static void fail(String message){
        extentTest.log(Status.FAIL,message);
    }

//this method will log and captures screenshot and attach them to the html report
    public static void passAndCaptureScreenshot(String message) throws IOException {
        extentTest.log(Status.PASS,message).addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
    }

    //FLUSH  MUST BE USED AT THE VERY END TO GENERATE THE REPORT
    @AfterSuite
    public static void flush(){
        extentReports.flush();
    }
}
