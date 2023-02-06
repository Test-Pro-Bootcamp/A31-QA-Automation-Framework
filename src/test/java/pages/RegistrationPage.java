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
    private WebElement registrationLink;
    @FindBy(css = "[class='login-wrapper']")
    private WebElement registrationPg;
    @FindBy(css = "[id='email']")
    private WebElement registrationEmail;
    @FindBy(css = "[id='button']")
    private WebElement registerButton;
    @FindBy(xpath = "//h3[contains(text(), 'Registration Successful')]")
    private WebElement registrationSuccessful;

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
