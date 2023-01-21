package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //locators
    @FindBy(css= "[type='submit']")
            WebElement submitButtonLocator;
//    By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css="[type='email']")
        WebElement emailField;
//    By emailField = By.cssSelector("[type='email']");
    @FindBy(css="[type='password']")
        WebElement passwordField;
//    By passwordField = By.cssSelector("[type='password']");

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
        provideEmail("guyvanalex4@gmail.com");
        providePassword("teststudent!1");
        clickSubmitBtn();
    }

}
