import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser() {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser() {
        LoginTests.driver.quit();
    }

    public static String url = "https://bbb.testpro.io/";

    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        LoginTests.driver.get(url);
    }

    public static void clickSubmit() {
        WebElement submitButton = LoginTests.driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = LoginTests.driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = LoginTests.driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void clickSaveButton() {
        WebElement saveButton = LoginTests.driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = LoginTests.driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = LoginTests.driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    protected static void clickAvatarIcon() {
        WebElement avatarIcon = LoginTests.driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}
