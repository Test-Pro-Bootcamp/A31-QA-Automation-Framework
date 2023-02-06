import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.safari.SafariDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeSuite;
        import org.testng.annotations.Parameters;

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

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void openBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        url = BaseURL;
        getDriver().get(url);
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.2:4444";

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud" :
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
    }
    public WebDriver lambdaTest () throws MalformedURLException {
        String username = "hand923";
        String accesskey = "cDR5kRIcyvPTcTkoBl26dgOBuJArxvLFBPEMzj46DMygHnGo0M";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "108.0");
        capabilities.setCapability("build", "Selenium 4");
        capabilities.setCapability("name", this.getClass().getName());
        capabilities.setCapability("seCdp", true);
        capabilities.setCapability("selenium_version", "4.0.0");

        return new RemoteWebDriver(new URL("http://" + username + ":" + accesskey + hub), capabilities);
    }
}
