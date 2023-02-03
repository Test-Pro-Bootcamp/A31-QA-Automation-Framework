package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
            }
     public void provideEmail(String email){
         WebElement emailElement = driver.findElement(emailField);
         emailElement.click();
         emailElement.sendKeys(email);
     }
     public void providePassword(String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
           }
      public void submitBtn(){
        driver.findElement(submitButtonLocator).click();
      }
}
