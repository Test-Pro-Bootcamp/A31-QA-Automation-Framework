package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class ProfilePage extends BasePage {

    @FindBy(css = "[name='current_password']")
    WebElement currentPassword;
    @FindBy(css = "[name='name']")
    WebElement profileName;
    @FindBy(css = "button.btn-submit")
    WebElement saveButton;
    @FindBy(css = "img.avatar")
    WebElement avatarIcon;

    public ProfilePage (WebDriver givenDriver){
        super(givenDriver);
    }

    public  String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public  void provideCurrentPassword(String password){
        wait.until(ExpectedConditions.elementToBeClickable(currentPassword));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public  void provideProfileName(String randomName){
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public  void clickSaveButton(){
        saveButton.click();
    }

    public  void clickAvatarIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        avatarIcon.click();
    }

}
