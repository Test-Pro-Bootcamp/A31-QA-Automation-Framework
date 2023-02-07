package pages;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

        //locators

//    pom
//        By submitButtonLocator = By.cssSelector("[type='submit']");
//        By emailFieldLocator = By.cssSelector("[type='email']");
//        By passwordFieldLocator = By.cssSelector("[type='password']");

//    page factory

    @FindBy(css="[type='email']")
    WebElement emailField;

    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver givenDriver) {super(givenDriver);}

        public LoginPage provideEmail(String email) {
            emailField.sendKeys(email);
            return this;
            }

        public LoginPage providePassword(String password) {
            passwordField.sendKeys(password);
            return this;
        }
        public LoginPage clickSubmitBtn() {
            submitButton.click();
            return this;
        }

        public LoginPage logIn() {
            provideEmail("tatsianahuryeva@yahoo.com");
            providePassword("te$t$tudent");
            clickSubmitBtn();
           return this;
        }


    }


