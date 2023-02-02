package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver dvr) {
        super(dvr);
    }

    @FindBy(css="button[type='submit']") WebElement submitButtonLocator;
    @FindBy(css="[type='email']") WebElement emailField;
    @FindBy(css="[type='password']") WebElement passwordField;

    public void provideEmail(String email){
       emailField.sendKeys(email);
    }

    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn(){
        submitButtonLocator.click();
    }
}
