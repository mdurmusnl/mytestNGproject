package com.myapp.tests.listeners;

import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ListenersTest3 {
    /*
  if a test case failes , then that test case is run again thanks to Listeners retry method
  this method below will fail but it will rerun automatically
  We are able to rerun failed test cases multiple times using test ng listeners with retryAnalyzer
  note"  this class is linked to retryAnalyzer with annotation
  we can also link a clss using xml files  just like ListenerTest2 class
     */
    @Test (retryAnalyzer = com.myapp.utilities.ListenersUtil.class)
    public void test4(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.id("wrong id"));//FAILED NO SUCH
        //throw new NoSuchElementException("no such");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
