package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage (WebDriver givenDriver){
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public  String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public  void provideCurrentPassword(String password){
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public  void provideProfileName(String randomName){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public  void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public  void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }


}
