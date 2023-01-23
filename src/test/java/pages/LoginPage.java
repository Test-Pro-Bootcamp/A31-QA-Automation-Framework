package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    // locators
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");
    By submitButton = By.cssSelector("button[type='submit']");


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement emailElement = driver.findElement(passwordField);
        emailElement.click();
        emailElement.sendKeys(password);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitButton).click();
    }
}
