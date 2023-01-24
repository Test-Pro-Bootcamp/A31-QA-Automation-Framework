package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pages.BasePage {

    //Locators
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;


//    @FindBy(css = "[test]")
//    WebElement email;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }
    public LoginPage login(){
        provideEmail("jrpasia@gmail.com");
        providePassword("B3n@iah2013");
        clickSubmitBtn();
        return  this;
    }

}
