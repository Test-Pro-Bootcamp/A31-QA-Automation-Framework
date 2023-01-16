package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");
    By  submitButton = By.cssSelector("button[type = 'submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email){
            WebElement emailElement = driver.findElement(emailField);
            emailElement.click();
            emailElement.sendKeys(email);
        }

        public void providePassword(String password) {
            WebElement passwordElement = driver.findElement(passwordField);
            passwordElement.click();
            passwordElement.sendKeys(password);
        }

        public LoginPage clickSubmit(){
            driver.findElement(submitButton).click();
            return this;
        }
        
        public void login(){
            provideEmail("shalinibaronia@gmail.com");
            providePassword("te$t$tudent");
            clickSubmit();
    }
}

