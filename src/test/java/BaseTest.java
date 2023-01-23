import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;
    public FluentWait fluentWait = null;

    public ThreadLocal<WebDriver> threadDriver = null;

    @BeforeSuite
    public void setupClass() {
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
//        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        getDriver().get(url);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.160:4444";

        switch (browser) {
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
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {
//        String LT_USERNAME = "khaledoni01";
//        String LT_ACCESS_KEY = "Zx0HIXlEJ9ERHjcH9UDCvNXRoiSm2si9VM3L6Dii3SX6W1GPF4";
//        String hub = "@hub.lambdatest.com/wd/hub";

        String hubURL = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "95");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user","khaledoni01");
        ltOptions.put("accessKey", "Zx0HIXlEJ9ERHjcH9UDCvNXRoiSm2si9VM3L6Dii3SX6W1GPF4");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("version", "107");
//        caps.setCapability("resolution", "2560 x 1440");
//        caps.setCapability("build", "TestNG for With Java");
//        caps.setCapability("name", this.getClass().getName());
//        caps.setCapability("plugin", "Windows 10");
//        caps.setCapability("platform", "git-testng");
//        return new RemoteWebDriver(new URL("https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + hub), caps);
    }


//    protected static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSaveButton() {
        WebElement saveButton = getDriver().findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = getDriver().findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = getDriver().findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = getDriver().findElement(By.cssSelector("img.avatar"));
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
