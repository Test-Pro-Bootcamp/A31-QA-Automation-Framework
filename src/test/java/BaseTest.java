import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static FluentWait fluentWait = null;


    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
//      LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.50.46:4444/";

        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "Firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-safari":
                caps.setCapability("browserName", "Safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "Chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
    }

    public static void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

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
