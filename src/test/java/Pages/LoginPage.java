package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(css = "[type = 'email']")
    WebElement emailField;

    @FindBy(css = "[type = 'password']")
    WebElement passwordField;

    @FindBy(css = "button[type = 'submit']")
    WebElement submitButton;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public LoginPage login(){
        provideEmail("shalinibaronia@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        return this;
    }
}
