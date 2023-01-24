package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //locators

    //By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css ="[type='submit']")
    WebElement submitButtonLocator;
    //By emailField = By.cssSelector("[type='email']");
    @FindBy(css = "[type='email']")
    WebElement emailField;
    //By passwordField = By.cssSelector("[type='password']");
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn() {
        wait.until(ExpectedConditions.visibilityOf(submitButtonLocator)).click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;

    }

    public void logIn(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
