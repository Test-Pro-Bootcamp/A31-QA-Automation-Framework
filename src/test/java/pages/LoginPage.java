package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    //locators
     @FindBy(css = "[type='submit']" )
    private WebElement submitButtonLocator;
    @FindBy(css="[type='email']")
    private WebElement emailField;
    @FindBy(css="[type='password']")
    private WebElement passwordField;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    



    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);


    }


    public void clickSubmitBtn() {
        submitButtonLocator.click();
    }

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);

    }

    public void logIn(){
        provideEmail("terrence.regis@gmail.com");

    

        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }

    public void clickProfileIcon() {
        click(profileIcon);
    }

}
