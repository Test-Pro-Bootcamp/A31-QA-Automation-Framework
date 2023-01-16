package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

public class LoginPage extends BasePage {

    //Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
//        emailField.clear();
        emailElement.click();
        emailElement.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
//        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement
//        passwordField.clear();
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        submitButtonElement.click();
    }

    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
}
