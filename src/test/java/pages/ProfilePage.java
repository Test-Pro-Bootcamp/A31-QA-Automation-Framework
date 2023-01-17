package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    WebDriver driver;
    WebElement wait;


    public static void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }

    @DataProvider(name="incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {

        return new Object[][] {
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}
