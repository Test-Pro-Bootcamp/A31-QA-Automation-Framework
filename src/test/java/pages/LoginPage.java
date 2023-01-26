package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //locators
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
//    By submitButtonLocator = By.cssSelector("[type='submit']");
//    By emailField = By.cssSelector("[type='email']");
//    By passwordField = By.cssSelector("[type='password']");

    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
//        driver.findElement(submitButtonLocator).click();
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
//        driver.findElement(emailField).sendKeys(email);
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
//        driver.findElement(passwordField).sendKeys(password);
    }

    public void logIn(){
        provideEmail("jimmypvu@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
