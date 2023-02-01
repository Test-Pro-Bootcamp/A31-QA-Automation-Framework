package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver dvr) {
        super(dvr);
    }

    By submitButtonLocator = By.cssSelector("button[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    public void provideEmail(String email){
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }
}
