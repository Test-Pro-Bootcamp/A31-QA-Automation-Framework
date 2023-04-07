package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    //locators
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    //  By submitButtonLocator = By.cssSelector("[type='submit']");
    //  By emailField = By.cssSelector("[type='email']");
    //  By passwordField = By.cssSelector("[type='password']");

    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        //wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButtonLocator.click();
        return this;
    }

    public void logIn() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
