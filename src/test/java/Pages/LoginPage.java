package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");


    public LoginPage(WebDriver givenDriver) { super(givenDriver); }

    public void provideEmail(String email) { driver.findElement(emailFieldLocator).sendKeys(email); }

    @Find(css="[test]")
    WebElement email;

    public void providePassword(String password) { driver.findElement(passwordFieldLocator).sendKeys(password); }

    public LoginPage clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    public void login(){
        provideEmail("jrpasia@gmail.com");
        providePassword("B3n@iah2013");
        clickSubmitBtn();
    }
    }
