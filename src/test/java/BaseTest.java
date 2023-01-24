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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public ThreadLocal<WebDriver> threadDriver = null;

    public Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        url = BaseUrl;

        threadDriver=new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().get(url);
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities dCap = new DesiredCapabilities();
        String gridURI = "http://192.168.86.32:4444";
        switch (browser) {
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
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "108.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user", "shalinibaronia");
        ltOptions.put("accessKey", "fPH3tVYv2I2ZMOQGbtMgkKRXMVoMIN4ya76moFRzQkigGFIOn8");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("w3c", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), capabilities);
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