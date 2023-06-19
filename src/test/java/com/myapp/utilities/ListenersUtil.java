package com.myapp.utilities;

import org.apache.commons.collections4.functors.IfTransformer;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtil implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    /*
  Listeners are used to LISTEN the test classes when they pass, fail, skip, start, end,...
  They are used to customize the testNG framework
  We will also use Listeners for adding special functionality under speci cases,
  such as take the screenshot for only failed test cases, or rerun the faieled test case more than once automatically
  onStart,onFinish,onTestStart,onTestFinish,... are special method names
   */
    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart : execute ONCE before ALL test cases(@Test) : "+context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish : execute ONCE after ALL test cases(@Test) : "+context.getName());
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart : execute ONCE before EACH test cases(@Test) : "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess : execute ONCE after EACH PASSING test cases(@Test) : "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
      //  System.out.println("onTestFailure : execute ONCE after EACH FAILED test cases(@Test) : "+result.getName());
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped : execute ONCE after EACH SKIPPED test cases(@Test) : "+result.getName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage : execute ONCE based on total test success percentage : "+result.getName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout : execute ONCE after EACH failed test case due to a TIMEOUT ISSUE : "+result.getName());
    }
    //    IRetryAnalyzer Method Is Implemented
    // this method will be called automatically to retry the failed test cases
    private int retryCount = 0;
    private static final int maxRetryCount = 3; //rerun three time
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
    //    IIAnnotationTransformer method is added
    // this makes the failed test case automatically rerun using tentNG xml file
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtil.class);
    }



}
/*
1. In utilities package, create a ListenersUtil class
Listeners class has all ITestListeners methods. That class Implements ITestListeners interface. This is like a TestBase class
2. Implement ITestListener
3. Add the ITestListener Methods
———————————————-
4. In tests package, create a new package : listeners
5. In listeners package, create a new java class : ListenersTest1
6. There are 2 ways to connect Listeners and Test Classes
Use this in the test class : @Listeners(techproed.utilities.Listeners.class)
Or
Add listeners tag before test in the xml file to connect Listeners and this xml file
<listeners>
    <listener class-name="techproed.utilities.Listeners"></listener>
</listeners>
 */