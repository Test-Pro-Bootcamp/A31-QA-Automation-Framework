import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
    public  WebDriver driver = null;
    public  String url = null;
    public  WebDriverWait wait = null;
    public  FluentWait fluentWait = null;
    public  Actions actions = null;

    // we declared threadDriver variable here. because we would like to access it in different methods
     ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
     void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {

        //creating the object
        threadDriver = new ThreadLocal<>();

        driver = pickBrowser(System.getProperty("browser"));

        //setting driver
        threadDriver.set(driver);

        //Khaled commented this out at 52:11
        //actions = new Actions(getDriver());

        //Khaled commented this out at 52:16
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Khaled commented this out at 52:25
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        driver.manage().window().maximize();
        url = BaseURL;
        getDriver().get(url);

    }


    @AfterMethod
    public void tearDownBrowser(){
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }

    private WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.210:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return  driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions= new EdgeOptions();
                edgeOptions.addArguments ("--remote-allow-origins=*");
                return  driver = new EdgeDriver(edgeOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return  driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
//                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments ("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
                //driver = new ChromeDriver();
        }
//        return driver;
    }


    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "zyabruk";
        String authkey = "7VYRBQCthZ8HK1JkShN7KKV4e3sZyxx4YsHac9cacMKZYdzutg";
        String hub = "@hub.Lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
//  your capabilities are configured here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "102.0");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("build", "Lambda Test w TestNG and Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }


    public void login() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
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
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }

    @DataProvider(name="incorrectLoginProviders")
    public Object[][] getDataFromDataproviders() {

        return new Object[][] {
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}
