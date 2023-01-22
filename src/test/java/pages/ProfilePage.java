package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;

import java.util.UUID;

public class ProfilePage extends BasePage {

    //WebElements
    @FindBy(css = "[name='current_password']")
    private WebElement currentPassword;
    @FindBy(css = "[name='name']")
    private WebElement profileName;
    @FindBy(css = "[type='email']")
    private WebElement emailAddress;
    @FindBy(css = "button.btn-submit")
    private WebElement saveButton;

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideCurrentPassword(String password) {
        currentPassword.sendKeys(password);
    }

    public void provideProfileName(String randomName) {
        profileName.sendKeys(randomName);
    }

    public void provideEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void clickSaveButton() {
        saveButton.click();
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
