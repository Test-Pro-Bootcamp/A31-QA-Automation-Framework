package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

//    WebDriver driver;
//    WebDriver wait;

    //Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    @FindBy(css = "[test]")
    WebElement email;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

//    public LoginPage(WebDriver givenDriver) {
//        driver = givenDriver;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    }
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
    public void clickSubmitBtn(){
        driver.findElement(submitButton).click();
    }
    public void login(){
        provideEmail("jrpasia@gmail.com");
        providePassword("B3n@iah2013");
        clickSubmitBtn();
    }

    }
