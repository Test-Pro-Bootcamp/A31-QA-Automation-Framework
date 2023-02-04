package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //WebElement
    @FindBy(css = "[name='current_password']")
    private WebElement currentPassword;
    @FindBy(css = "[name='name']")
    private WebElement profileName;
    @FindBy(css = "[type='email']")
    private WebElement emailAddress;
    @FindBy(css = "button.btn-submit")
    private WebElement saveButton;
    @FindBy(css = "a.view-profile")
    private WebElement profileIcon;
    @FindBy(css = "div.success.show")
    private WebElement successMsg;
    @FindBy(css = "[data-testid='theme-card-violet']")
    private WebElement violetTheme;
    @FindBy(xpath = "//div[@data-testid='theme-card-violet' and contains(@class,'selected')]")
    private WebElement verifySelectedVioletTheme;

    public void provideCurrentPassword(String password) {
        currentPassword.sendKeys(password);
    }

    public void provideProfileName(String randomName) {
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean getSuccessPopUp() {
        return successMsg.isDisplayed();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickProfileIcon() {
        profileIcon.click();
    }

    public void chooseVioletTheme() {
        violetTheme.click();
    }

    public boolean isVioletThemeSelected() {
        return verifySelectedVioletTheme.isDisplayed();
    }

}
