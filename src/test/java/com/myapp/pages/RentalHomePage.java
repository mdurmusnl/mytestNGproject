package com.myapp.pages;

import com.myapp.utilities.Driver;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalHomePage {


    public RentalHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(linkText = "Logout")
    public WebElement logOut;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;
}