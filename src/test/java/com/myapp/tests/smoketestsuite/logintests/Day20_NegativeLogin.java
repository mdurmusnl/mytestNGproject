package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import com.myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_NegativeLogin {
    /*
    US100208_Negative_Login
Description:
User should not be able login with incorrect credentials
Acceptance Criteria:
As customer, I should not be able to log in the application
incorrect username and incorrect password
Customer email: fake@bluerentalcars.com
Customer password: fakepass
Error: User with email fake@bluerentalcars.com not found
     */

    @Test
    public void US100208_Negative_Login(){
//        As customer, I should not be able to log in the application
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();
//        Customer email: fake@bluerentalcars.com
        rentalLoginPage.userEmail.sendKeys("fake@bluerentalcars.com");
//        Customer password: fakepass
        rentalLoginPage.userPassword.sendKeys("fakepass");
        rentalLoginPage.loginButton.click();
        //without waiting, test case failes becasue the element pops up on a web alert that causes synchronization
            //there are 2 vwaits we can use
             //1  WaitUtils.waitFor(3);    hard wait
  //    2     WaitUtils.waitForVisibility(rentalLoginPage.errorMessage_incorrectEmailAndPass,3);
        //        Error: User with email fake@bluerentalcars.com not found
//then below assertion passes
        //String errorText = rentalLoginPage.errorMessage_incorrectEmailAndPass.getText();
        //    Assert.assertEquals(errorText,"User with email fake@bluerentalcars.com not found");

        //        *******BUT WE CAN USE REUSABLE METHOD TO DO TEXT ASSERTION QUICKER
//        ReusableMethods.
//                verifyActualAndExpectedTextMatch("User with email fake@bluerentalcars.com not found",
//                        rentalLoginPage.errorMessage_incorrectEmailAndPass);
//        Driver.closeDriver();
    }
    }
/*
 @BeforeMethod
    public void OptionsAreVisibleTest(){
       PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
       PearlyMarketSignInPage pearlyMarketSignInPage = new PearlyMarketSignInPage();
       //Go to the url
       Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
      //Click on sign in
      ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signInHome, 3);
      //Enter username or email
      ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.usernameOrEmail,ConfigReader.getProperty("andrey_fake_email"), 3);


      //Enter password
      ReusableMethod.sendKeysWithTimeout(pearlyMarketSignInPage.password, ConfigReader.getProperty("andrey_vendor_psw"), 3);


      //Click on sign-in
      ReusableMethod.clickWithTimeOut(pearlyMarketSignInPage.signIn, 3);
       //Click on mY Account
      ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.myAccount, 3);


   }
   @Test
    public void test1() throws Exception {
       PearlyMarketMyAccountPage pearlyMarketMyAccountPage =new PearlyMarketMyAccountPage();
       PearlyMarketMyStorePage pearlyMarketMyStorePage= new PearlyMarketMyStorePage();
       //User clicks the Store Manager
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.storeManager, 3);
       //User clicks the Products
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.products, 3);
       //User clicks the Add New Product
       ReusableMethod.clickWithTimeOut(pearlyMarketMyAccountPage.addNewProducts, 3);
       //verify that user sees add product page
       ReusableMethod.verifyElementDisplayed(pearlyMarketMyStorePage.photo);
       //User sees the options in the dropwdown box

       ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productTitle,"Phone",3);
         ReusableMethod.switchIframeByWebElement("//iframe[@id='excerpt_ifr']");
       WaitUtils.waitFor(3);


     ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"hi",3);
     Driver.getDriver().switchTo().defaultContent();
       WaitUtils.waitFor(3);
       ReusableMethod.switchIframeByWebElement("//iframe[@id='description_ifr']");

       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.description,"hello",3);
       Driver.getDriver().switchTo().defaultContent();
//       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"sd",3);
   //ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.description,3);





   }
//
//   @Test
//    public void test2(){
//       PearlyMarketMyStorePage pearlyMarketMyStorePage= new PearlyMarketMyStorePage();
//       ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
//      // ReusableMethod.selectDropdownByValue(pearlyMarketMyStorePage.productType,"Variable Product");
//
//
//   }

 @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement photo;
    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement productType;
    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;


    //Iframe of send key to short describtion
    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement iframeSd;

    //Iframe of send key to Description
    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement iframeD;

   //first iframe short discription box
    @FindBy(xpath = "//body[@data-id='excerpt']")
    public WebElement shortDescription;

    //secinf iframe description box
    @FindBy(xpath = "//body[@data-id='description']")
    public WebElement description;
 */