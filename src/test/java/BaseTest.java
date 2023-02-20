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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;
    ThreadLocal<WebDriver> threadDriver;


//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.firefoxdriver().setup();
//    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(@Optional String BaseURL) throws MalformedURLException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = pickBrowser(System.getProperty("browser"));

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
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
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.10:4444";

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
                caps.setCapability("browserName", "MicrosoftEdge");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                break;
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                break;
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
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
        String username = "nicole.liano";
        String authkey = "zO4pgj8usYjTbYYt9wKx3WicHfATRgsMjoYeHkwq5mThNgh2rl";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "106.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @DataProvider(name="IncorrectLoginProvider")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@email.com", "invalidPas"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }

}
