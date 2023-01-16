package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;
    //locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LogInPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    @Test
    public void LogInValidEmailTest() {
        LogInPage logInPage = new LogInPage(driver);

        logInPage.provideEmail("skymena75@gmail.com");
        logInPage.providePassword("te$t#tudent");
        logInPage.clickSubmitButton();

        Assert.assertTrue(HomePage.getUserAvatar().isDisplayed());
    }
}