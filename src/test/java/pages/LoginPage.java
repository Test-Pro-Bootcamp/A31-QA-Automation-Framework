package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LoginPage extends BasePage{

    //Web Elements
    @FindBy (css="[type='email']")
    WebElement emailField;
    @FindBy (css="[type='password']")
    WebElement passwordField;
    @FindBy (css="button[type='submit']")
    WebElement submitButton;

    //Constructor
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page methods
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitButton(){
        submitButton.click();
        return this;
    }


}
