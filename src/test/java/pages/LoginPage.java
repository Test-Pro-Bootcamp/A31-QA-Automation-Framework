package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //WebElement
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    @FindBy(css = ".error")
    private WebElement loginErrorMsg;

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        emailField.click();
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        passwordField.click();
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    //Login
    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public WebElement loginError() {
        return loginErrorMsg;
    }

    public WebElement emailFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailField));
    }
}
