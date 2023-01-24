package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

    By profileIcon  = By.xpath("//a[@class='view-profile']");


    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginPage logIn(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }

    public void clickProfileIcon() {
        click(profileIcon);
    }

}
