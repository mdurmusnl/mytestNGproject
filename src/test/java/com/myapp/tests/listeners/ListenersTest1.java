package com.myapp.tests.listeners;
import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

@Listeners(com.myapp.utilities.ListenersUtil.class)//PATH OF THE UTIL CLASS
public class ListenersTest1 {
    /*
We can link this class and listeners using @Listeners annotation or xml file
In this class we will use @Listeners
 */
    @Test
    public void test1(){
        System.out.println("PASS");
        assertTrue(true);
    }
    @Test
    public void test2(){
        System.out.println("FAIL");
        assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("SKIP");
        throw new SkipException("SKIPP THIS TEST CASE FOR TESTING PURPOSE");
    }
    @Test
    public void test4(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.id("wrong id"));//FAILED NO SUCH
        //throw new NoSuchElementException("no such");
    }

}


/*
 PearlyMarketHomePage pearlyMarketHomePage= new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage=new PearlyMarketRegisterPage();
        // user visits home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // user clicks Register button
        pearlyMarketHomePage.register.click();
        // user enters an already existing username
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,ConfigReader.getProperty("andrey_username"),6);
        // user enters an already existing email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,ConfigReader.getProperty("andrey_email"),6);
        // user enters a password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,ConfigReader.getProperty("andrey_password"),6);
        // user clicks the confrim box "I agree to the privacy policy"
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.confirmBox,3);
        // user clicks sign up button
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signUpButton,3);
        //verift that user see the error message "An account is already registered with your email address."
        ReusableMethod.verifyElementDisplayed(pearlyMarketHomePage.existingCredentialsErrorMessage);
        Driver.closeDriver();
negative
PearlyMarketHomePage pearlyMarketHomePage= new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage=new PearlyMarketRegisterPage();
        // user visits home page
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_home_page"));
        // user clicks Register button
        pearlyMarketHomePage.register.click();
     String fakeUsername=faker.name().username();
     String fakeEmail=faker.internet().emailAddress();
     String  fakePassword=faker.internet().password();
        // user enters an already existing username
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.usernameBox,fakeUsername,3);
        // user enters an already existing email
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.emailBox,fakeEmail,6);
        // user enters a password
        ReusableMethod.sendKeysWithTimeout(pearlyMarketHomePage.passwordBox,fakePassword,6);
        // user clicks the confrim box "I agree to the privacy policy"
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.confirmBox,3);
        // user clicks sign up button
        ReusableMethod.clickWithTimeOut(pearlyMarketHomePage.signUpButton,3);
        //verify that user sees sign out button/gi
       ReusableMethod.verifyElementDisplayed(pearlyMarketRegisterPage.successfulRegister);

       14

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

negatice
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

       //Checking if every option in dropdown is selectable
       WebElement dropdown=Driver.getDriver().findElement(By.xpath("//select[@id='product_type']"));
       Select options= new Select(dropdown);
          List<WebElement> dropdownOptions= options.getOptions();
       for (WebElement w : dropdownOptions){
           w.click();
           System.out.println(w.getText());
       }
       //user clicks virtual box
       ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.virtualBox,3);
       //user adds a product photo
       WebElement chooseAFile = Driver.getDriver().findElement(By.id("gallery_img_gimage_0_display"));
       String userHome = System.getProperty("user.home");
       String pathOfPhone=userHome+"\\OneDrive\\Desktop\\phone.png";
       ReusableMethod.sendKeysWithTimeout(chooseAFile,pathOfPhone,3);    //failssss?????

       //user adds product title
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productTitle,"Phone",3);
       //switch to iframes to type in text field of short describtion
         ReusableMethod.switchIframeByWebElement("//iframe[@id='excerpt_ifr']");
       WaitUtils.waitFor(3);

  //user fills the text field
     ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.shortDescription,"hi",3);
       //swith back to default page from iframe
     Driver.getDriver().switchTo().defaultContent();
       WaitUtils.waitFor(3);
       //switch to an iframe of description text field
       ReusableMethod.switchIframeByWebElement("//iframe[@id='description_ifr']");
       //user fills the description text field
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.description,"hello",3);
       //switch back to default page
       Driver.getDriver().switchTo().defaultContent();
       //user select a category
  ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.categories,3);
       //user adds New Categories.
 ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.addnewCategories,3);
         //user adds a new category
 ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.categoryName,"ABC",3);
      //user sleect a parent category from a dropwdown
       ReusableMethod.selectByVisibleText(pearlyMarketMyStorePage.parentCategory,"      Mobile");

  ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.productBrandsName,3);
  //user add new product brand
       ReusableMethod.clickWithTimeOut(pearlyMarketMyStorePage.addNewProductBrand,3);
       //user types a product name
       ReusableMethod.sendKeysWithTimeout(pearlyMarketMyStorePage.productBrandsName,"CBA",3);
       //user select an element from dropdown
       ReusableMethod.selectByVisibleText(pearlyMarketMyStorePage.parentTaxonomy,"         Samsung");

  //verift that vategories, product brand, product type and photo are clickable
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.categories);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.productBrandsName);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.productType);
  ReusableMethod.verifyElementClickable(pearlyMarketMyStorePage.photo);
  for (WebElement w:dropdownOptions){
      ReusableMethod.verifyElementClickable(w);

      PearlyMarketHomePage
@FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInHome;
    @FindBy(xpath = "//i[@class='w-icon-hamburger']")
    public WebElement MyAccount;


    @FindBy(xpath = "//span[text()='Register']")
    public WebElement register;


    @FindBy(xpath = "//input[@id='reg_username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement emailBox;
    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@id='register-policy']")
    public WebElement confirmBox;
    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement signUpButton;
    @FindBy(xpath = "//p[text()='An account is already registered with that username. Please choose another.']")
    public WebElement usernameErrorMessage;

    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']")
    public WebElement existingCredentialsErrorMessage;
    @FindBy(xpath = "//p[text()='An account is already registered with your email address. ']")
    public WebElement existingEmailErrorMessage;
    @FindBy(xpath = "(//div//small)[1]")
    public WebElement weakPswMessage;






    @FindBy(xpath = "//li[@id='menu-item-1079']")
    public WebElement myAccount;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement SignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement vendorUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement vendorPassword;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInButton;

    //Search box to search for products

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public WebElement searchBox;

    //My Account element
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountt;

PearlyMarketMyStorePage

@FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualBox;
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

    @FindBy(xpath = "//input[@value='428']")
    public WebElement categories;

    //add new categories
    @FindBy(xpath = "//p[text()='+Add new category']")
    public WebElement addnewCategories;

    //category name
    @FindBy(xpath = "//input[@id='wcfm_new_cat']")
    public WebElement categoryName;
    //PARENT CATEGORY
    @FindBy(xpath = "//select[@id='wcfm_new_parent_cat']")
    public WebElement parentCategory;

    @FindBy(xpath = "//p[text()='+Add new Product brands']")
    public WebElement addNewProductBrand;

    //new product brand
    @FindBy(xpath = "//input[@id='wcfm_new_product_brand']")
    public WebElement productBrandsName;
    //dropdow for parent taxonomy
    @FindBy(xpath = "//select[@id='wcfm_new_parent_product_brand']")
    public WebElement parentTaxonomy;

 */