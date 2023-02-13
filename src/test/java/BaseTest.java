import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;


public class BaseTest {
    static WebDriver driver = null;
    static String url = null;
    static WebDriverWait wait = null;
    static Actions actions = null;
    static ThreadLocal<WebDriver>threadLocal = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome","chromedriver.exe");
        } else{
            System.setProperty("webdriver.chrome.driver","chromedriver");
        }
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        url = BaseURL;
        threadLocal = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadLocal.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }
    public static WebDriver getDriver() {
        return threadLocal.get();
    }


    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.160:4444";

        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
  //          case "cloud":
  //              return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
    }
 /*   public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "tatsiana.guryev";
        String accessKey = "HRqintf83dtNQoQm3VkfTYC21LmK3M9zHSV3EdblnNTTaPeFT7";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion","110");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();

        ltOptions.put("username", "tatsiana.guryev");
        ltOptions.put("accessKey", "HRqintf83dtNQoQm3VkfTYC21LmK3M9zHSV3EdblnNTTaPeFT7");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options",ltOptions);

       return new RemoteWebDriver(new URL("https://"+ username +":" + accessKey + hub),capabilities );
 }
*/
    @AfterMethod
    public static void closeBrowser(){
        //    LoginTests.driver.quit();
        getDriver().quit();
        threadLocal.remove();
    }

    public static void login(String email, String password) {
        provideEmail("tatsianahuryeva@yahoo.com");
        providePassword("te$t$tudent");
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
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }


    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar")));
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
