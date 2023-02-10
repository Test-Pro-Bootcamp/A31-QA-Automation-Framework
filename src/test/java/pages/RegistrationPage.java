package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegistrationPage extends BasePage{

    @FindBy(css = "[class='login-wrapper']")
    private WebElement registerNewAccountText;
    @FindBy(css = "[id='email']")
    private WebElement regiEmail;
    @FindBy(css = "[id='button']")
    private WebElement registerBtnlocator;
    private By byregistrationLink = By.cssSelector("[id='hel']");
    @FindBy(xpath = "//h3[contains(text(), 'Registration Successful')]")
    private WebElement registrationSuccessfulMsg;
    private By byregistrationSuccessfulMsg = By.xpath("//h3[contains(text(), 'Registration Successful')]");
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickRegistrationLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(byregistrationLink)).click();
    }
    public void validateRegisterNewAccountTextPresent() {
        Assert.assertTrue(registerNewAccountText.isDisplayed());
    }

    public void enterRegistrationEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(regiEmail)).click();
        regiEmail.sendKeys(email);
    }
    public void registerBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtnlocator)).click();
    }
    public WebElement showRegistrationSuccessMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byregistrationSuccessfulMsg));
        return registrationSuccessfulMsg;
    }
}
