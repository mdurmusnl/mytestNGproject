package com.myapp.tests.smoketestsuite.logintests.ecelautomation;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day21_ExcelLogin {
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
    ExcelUtils excelUtils;                //to call the ExcelUtil constructor and methods
    List<Map<String, String>> dataList;   //will be used to stire data

    @Test
    public void customerLoginTest() throws InterruptedException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
        excelUtils =new ExcelUtils(path,sheetName);
        dataList=excelUtils.getDataList();
        System.out.println(dataList);
        for(Map<String ,String > eachData : dataList){
 //           go to home page

        //      rentalHomePage.loginLink.click();   i got syncronization issue in here  hard wait fixed it but below is better
            ReusableMethods.clickWithTimeOut(rentalHomePage.loginLink,6);
          //*****     //WaitUtils.waitFor(1); i can als use this at any step i need  *****

 //           enter username  //in the excel username is key   email is value
     rentalLoginPage.userEmail.sendKeys(eachData.get("username"));//get dat  from excel
 //           enter password
     rentalLoginPage.userPassword.sendKeys(eachData.get("password")); //get dat  from excel
            //WaitUtils.waitFor(1);   if i need
//            click on login button
      rentalLoginPage.loginButton.click();
            //WaitUtils.waitFor(1);  if i need
//            verify login
            ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
            //WaitUtils.waitFor(1);  if i need
 //           click on id
     rentalHomePage.userID.click();
            //WaitUtils.waitFor(1);  if i need
 //           click on logout
    rentalHomePage.logOut.click();
  //          click on ok
     rentalHomePage.OK.click();
        }
        Driver.closeDriver();
/*
TRY LOOPING THIS CONTENT
go to home page
click on login
enter username
enter password
click on login button
verify login
click on id
click on logout
click on ok
 */
/*
pseudo code:
***********
go to home page
---LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT----
click on id
click on logout
click on ok
----LOG IN---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
---LOG IN ---
click on home login link
enter username
enter password
click on login button
verify login is successful
---LOG OUT---
click on id
click on logout
click on ok
 */
    }

}
