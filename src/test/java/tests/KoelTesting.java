package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URI;

public class KoelTesting {

    BasePage basePage;
    LoginPage loginPage ;
    HomePage homePage;
    AllSongsPage allSongsPage;
    public WebDriver driver;

    @BeforeSuite
    public void setupClass() throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
    }

    @BeforeMethod
    @Parameters({"baseURL", "loginEmail", "loginPassword"})
    public void beforeMethod(String baseURL, String loginEmail, String loginPassword)
    {
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        allSongsPage = new AllSongsPage(driver);

        goToKoel(baseURL);
        logIntoKoel(loginEmail, loginPassword);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    public void goToKoel(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.13:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
                break;
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
                break;
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }


    public void logIntoKoel(String userName, String password)
    {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
    }
}
