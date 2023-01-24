package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    //locators
    @FindBy (css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
//    By submitButtonLocator = By.cssSelector("[type='submit']");
//    By emailField = By.cssSelector("[type='email']");
//    By passwordField = By.cssSelector("[type='password']");

    public LoginPage(WebDriver givenDriver) {
        super (givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public LoginPage provideEmail(String email) {
//        WebElement emailElement = driver.findElement(emailField);
//        emailElement.click();
//        emailElement.sendKeys(email);
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
//        WebElement passwordElement = driver.findElement(passwordField);
//        passwordElement.click();
//        passwordElement.sendKeys(password);
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

}