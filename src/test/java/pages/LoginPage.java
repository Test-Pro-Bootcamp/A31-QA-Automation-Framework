package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //locators
    @FindBy(css ="[type='submit']")
    private WebElement submitButtonLocator;

    @FindBy(css ="[type='email']")
    private WebElement emailField;

    @FindBy(css ="[type='password']")
    private WebElement passwordField;

    @FindBy(xpath ="//a[@class='view-profile']")
    private WebElement profileIcon;


    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage logIn(){
        provideEmail("abc@test.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }


}
