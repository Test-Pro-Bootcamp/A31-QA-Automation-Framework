package Homework23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage23 extends BasePage23 {

    @FindBy(css="[type='submit']")
            WebElement submitButtonLocator;

    @FindBy(css = "[type='email']")
            WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    //locators
  //  By submitButtonLocator = By.cssSelector("[type='submit']");
    //By emailField = By.cssSelector("[type='email']");
    //By passwordField = By.cssSelector("[type='password']");

    public LoginPage23( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage23 clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public LoginPage23 provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage23 providePassword(String password) {
       passwordField.sendKeys(password);
       return this;
    }

    public void logIn(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
