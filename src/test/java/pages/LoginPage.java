package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LoginPage extends BasePage{

    //Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By clickSubmitButton = By.cssSelector("button[type='submit']");

    //Constructor
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page methods
    public void login(String email, String password) {
        waitClick(emailField);
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).sendKeys(password);

        click(clickSubmitButton);
    }


}
