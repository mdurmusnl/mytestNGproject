package com.myapp.tests.topics;

import org.testng.annotations.*;

public class Day17_Annotations {
    /*
   @Test : creates a test case. marks a method as a test case. In this class there are 5 test cases. Same as JUNIT
   @Before and @After : there are 5 Before and 5 after annotations
   HYARARSHI : suite > test > group > class > method
   @Ignore : Skip/ignore test cases.Eg: ignore test3
   @Test(enable = false) : Disables the test case. By default, enable=true. Eg: disable test 4
    @Test(priority = priority number)
    */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("before group");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("after group");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }
    @BeforeMethod
    public static void beforeMethod(){
        System.out.println("before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }

    @Test(priority = 3)    //we can even say priority=200
    public void test01(){
        System.out.println("test01");
    }

    @Test (priority = 1)   //this case will be executed first   we can even say priority =-30
    public void test02(){
        System.out.println("test02");
    }

    @Test @Ignore
    public void test03(){
        System.out.println("test03");
    }

    @Test (enabled = false)   //stronger than @Ignore   it completely disables the test case
    public void test04(){
        System.out.println("test04");
    }

    @Test (priority = 2)
    public void test05(){
        System.out.println("test05");
    }
    @Test          //if there is a test case without a priority then its priority is 0
    public void test06(){
        System.out.println("test06");
    }

}
