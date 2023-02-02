import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {

//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    public static WebDriver driver;
    public static String url = "https://bbb.testpro.io/";
    public static WebDriverWait wait;
    public static Actions actions;
    public ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        url = BaseURL;
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().get(url);
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
        String gridURL = "http://192.168.1.211:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
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

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "108.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "greeshma.udupa");
        ltOptions.put("accessKey", "xMOZWn1H29b7wnvm1BncObwGHhAi6dC0LtfyvOLb8t1TvLrVcb");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("w3c", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }

}
