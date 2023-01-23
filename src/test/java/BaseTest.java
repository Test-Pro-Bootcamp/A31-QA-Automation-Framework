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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static ThreadLocal<WebDriver> threadDriver = null;
    public Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        url = BaseUrl;
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(url);
    }
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public static void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities dCap = new DesiredCapabilities();
        String gridURI = "http://192.168.86.32:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "grid-edge":
                dCap.setCapability("browserName", "MicrosoftEdge");
                driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);
                break;
            case "grid-firefox":
                dCap.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);
                break;
            case "grid-chrome":
                dCap.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }

    protected void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));

        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));

        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));
        submitButton.click();
    }
}