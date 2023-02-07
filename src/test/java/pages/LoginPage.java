package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css="[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css="[type='email']")
    WebElement emailField;
    @FindBy(css="[type='password']")
    WebElement passwordField;
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
            }
     public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
     }
     public LoginPage providePassword(String password){
         passwordField.sendKeys(password);
       return this;
    }
      public LoginPage submitBtn(){
        submitButtonLocator.click();
        return this;
     }
   /*  public void login(){
        provideEmail("karkisuman0330@gmail.com");
        providePassword("te$t$tudent");
        submitBtn();
    }*/
}

