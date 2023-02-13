package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[id='hel']")
    WebElement registrationLink;
    @FindBy(css = "[class='login-wrapper']")
    WebElement registrationPg;
    @FindBy(css = "[id='email']")
    WebElement registrationEmail;
    @FindBy(css = "[id='button']")
    WebElement registerButton;
    @FindBy(xpath = "//h3[contains(text(), 'Registration Successful')]")
    WebElement registrationSuccessful;

    public void registrationLink() {
        registrationLink.click();
    }

    public void registrationPage() {
        Assert.assertTrue(registrationPg.isDisplayed());
    }

    public void registrationEmail() {
        registrationEmail.click();
        registrationEmail.sendKeys("test3215@test.com");
    }

    public void registerButton() {
        registerButton.click();
    }

    public WebElement registrationSuccessMsg() {
        return registrationSuccessful;
    }
}