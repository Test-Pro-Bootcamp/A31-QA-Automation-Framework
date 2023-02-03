package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage extends BasePage{
    By submitButton = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By profileIcon  = By.xpath("//a[@class='view-profile']");



    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
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

    public LoginPage clickSubmit() {
       driver.findElement(submitButton).click();
        return this;
    }

    public LoginPage login(){
        provideEmail("shalinibaronia@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        return this;
    }

    public void clickProfileIcon() {
        click(profileIcon);
    }
}