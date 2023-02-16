package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    public LoginPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();
    }

    public void provideEmail (String email){
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword (String password){
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmitBtn (){
        submitButtonLocator.click();
    }

}
