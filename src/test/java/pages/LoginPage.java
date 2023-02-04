package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    //WebElements
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    //Locators
    By profileIcon = By.xpath("//a[@class='view-profile']");


    public LoginPage(WebDriver givenDriver) {
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

    public LoginPage logIn() {
        provideEmail("tatsianahuryeva@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        return this;
    }

    public void clickProfileIcon() {
        click(profileIcon);
    }

}
