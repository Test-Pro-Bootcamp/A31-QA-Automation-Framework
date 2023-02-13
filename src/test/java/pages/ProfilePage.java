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
    WebElement currentPassword;
    @FindBy(css = "[name='name']")
     WebElement profileName;
    @FindBy(css = "[type='email']")
     WebElement emailAddress;
    @FindBy(css = "button.btn-submit")
     WebElement saveButton;
    @FindBy(css = "a.view-profile")
     WebElement profileIcon;
    @FindBy(css = "div.success.show")
     WebElement successMsg;
    @FindBy(css = "[data-testid='theme-card-violet']")
     WebElement violetTheme;
    @FindBy(xpath = "//div[@data-testid='theme-card-violet' and contains(@class,'selected')]")
     WebElement verifySelectedVioletTheme;

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
