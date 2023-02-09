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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;


public class BaseTest  {


    public WebDriver driver;

    public WebDriverWait wait;
    public String url;
    public Actions action;
    public FluentWait fluentWait;

    public ThreadLocal<WebDriver> threadLocal;



    //private String url = "https://bbb.testpro.io/";

    @BeforeSuite
    public static void setupClass() {

        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadLocal = new ThreadLocal<>();
        threadLocal.set(driver);
        action = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
//        url = BaseURL;
        getDriver().get(BaseURL);

    }

    public WebDriver getDriver() {
        return threadLocal.get();
    }


    @AfterMethod
    public void closeBrowser() {
    getDriver().quit();
    threadLocal.remove();
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.43.53:4444/";
        //String gridURL = "http:localhost:4444";

        switch (browser) {
            case "firefox": //Mac not installed
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge": //Mac not installed
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
                return driver = new ChromeDriver();

        }

      return null;
    }




    public WebDriver lambdaTest() throws MalformedURLException {
        String hub = "@hub.lambdatest.com/wd/hub";
        String username = "david.heinrich";
        String authkey = "dNeMHzFmBK4YyxvbsQgMWzrEnEDbICVwPOvAbD0WW5opWA4xgp";


        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "106.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testing");


        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    //public static void navigateToPage() {
    // String url = "https://bbb.testpro.io/";
    // driver.get(url);}
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
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
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




