package Homework22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage22 extends BasePage22 {

    WebDriver driver;
    WebDriverWait wait;

    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField= By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public LoginPage22 (WebDriver givenDriver) { super(givenDriver);}

    public void provideEmail(String email) {driver.findElement(emailField).sendKeys(email);}

    @FindBy(css = "[test]")
    WebElement email;

    public void providePassword(String password) {driver.findElement(passwordField).sendKeys(password);}

    public LoginPage22 clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
