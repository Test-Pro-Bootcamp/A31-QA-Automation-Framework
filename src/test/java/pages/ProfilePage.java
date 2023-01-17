package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;

import java.util.UUID;

public class ProfilePage extends BasePage {

    By currentPassword = By.cssSelector("[name='current_password']");
    By profileName = By.cssSelector("[name='name']");
    By emailAddress = By.cssSelector("[type='email']");
    By saveButton = By.cssSelector("button.btn-submit");


    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPasswordElement = driver.findElement(currentPassword);
        currentPasswordElement.clear();
        currentPasswordElement.sendKeys(password);
    }

    public void provideProfileName(String randomName) {
        WebElement profileNameElement = driver.findElement(profileName);
        profileNameElement.clear();
        profileNameElement.sendKeys(randomName);
    }

    public void provideEmailAddress(String email) {
        WebElement emailAddressElement = driver.findElement(emailAddress);
        emailAddressElement.click();
        emailAddressElement.sendKeys(email);
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = driver.findElement(saveButton);
        saveButtonElement.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {

        return new Object[][]{
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}
