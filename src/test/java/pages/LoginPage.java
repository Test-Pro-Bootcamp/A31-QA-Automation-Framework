package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(css = "//a[@class='view-profile']")
    WebElement profileIcon;
   // "//a[@class='view-profile']"
    //"img.avatar"

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        submitButton.click();
        return this;
    }

    public LoginPage logIn() {
        provideEmail("tatsianahuryeva@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }
    public void clickProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
        profileIcon.click();
    }


}


