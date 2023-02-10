package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {

    //locators
    @FindBy(css = "[name='current_password']")
    private WebElement currentPassword;
    @FindBy(css = "[name='name']")
    private WebElement profileName;
    @FindBy(css = "[type='email']")
    private WebElement emailAddress;
    @FindBy(css = "button.btn-submit")
    private WebElement saveButton;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    private By bysuccessMsg = By.cssSelector("div.success.show");
    @FindBy(css = "a.view-profile")
    private WebElement profileIcon;
    @FindBy(css = "[data-testid='theme-card-violet']")
    private WebElement violetTheme;
    @FindBy(xpath = "//div[@data-testid='theme-card-violet' and contains(@class,'selected')]")
    private WebElement verifySelectedVioletTheme;

    private By byVerifySelectedVioletTheme = By.xpath("//div[@data-testid='theme-card-violet' and contains(@class,'selected')]");

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void provideCurrentPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(currentPassword)).sendKeys(password);
    }

    public void provideProfileName(String randomName) {
        wait.until(ExpectedConditions.elementToBeClickable(profileName)).clear();
        profileName.sendKeys(randomName);
    }

    public void provideEmailAddress(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailAddress)).clear();
        emailAddress.sendKeys(email);
    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public boolean getSuccessPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bysuccessMsg));
        return successMsg.isDisplayed();
    }

    public void chooseVioletTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(violetTheme)).click();
    }

    public boolean isVioletThemeSelected() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byVerifySelectedVioletTheme));
        return verifySelectedVioletTheme.isDisplayed();
    }

}