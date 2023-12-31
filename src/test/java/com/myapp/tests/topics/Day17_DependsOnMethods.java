package com.myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_DependsOnMethods {
    @Test
    public void homePage(){
        System.out.println("On the home page");
        Assert.assertFalse(true);//FAILS ON PURPOSE
    }
    //    Make seachPage test dependent on hte homePage test using dependsOnMethods
//    if homePage PASS only then  searchPage executes
//    if homePage FAILS then searchPage will be SKIPPED
    @Test(dependsOnMethods = "homePage")
    public void searchPage(){
        System.out.println("On the  search page");
    }
    @Test
    public void checkOutPage(){
        System.out.println("On the checkout page");
    }
}
