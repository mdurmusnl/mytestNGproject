package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPageObject {   //totaly imagination  bothing is real in here   this is just a github study purpose
    public CommonPageObject(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "id_email")
    public WebElement userEmail;

    @FindBy(id = "id_pwd")
    public WebElement userPassword;

    @FindBy(xpath = "//button[@type='login']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement errorMessage_incorrectEmailAndPass;



}
