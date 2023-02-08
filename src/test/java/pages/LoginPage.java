package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //locators
    @FindBy(css = "[type='submit']")
    private WebElement submitButtonLocator;
    @FindBy(css ="[type='email']" )
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickSubmitBtn() {
        submitButtonLocator.click();
    }
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);

    }
    public void logIn(){
        provideEmail("ABC@test.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

}
