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
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;


public class BaseTest {
   //remember if declaring non-primitive data types, must assign values-strings, arrays, classes
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    Actions action = new Actions(driver);

    //public static FluentWait  fluentWait = null;

    @BeforeSuite
    static void setupClass() {
    // WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        driver = pickBrowser(System.getProperty("browser"));
        //if use implicit wait after creation of ChromeDriver - always put it in BeforeMethod
        // LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
         //Explicit wait - create class variable outside of indiv method, so it can be used across the code
        // then do the second part
        // wait until element is available or clickable, then click on it
        wait = new WebDriverWait (LoginTests.driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://########:4444";

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
                caps.setCapability("browserName", "MicrosoftEdge" );
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "" );"firefox");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "" );"chrome");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
                default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

        }
        return driver;
    }
//    protected static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public static void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void clickSubmit() {
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        //by locator type
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        //some methods can use either locator or element, only locator or only element
        // by element syntax
        wait.until(ExpectedConditions.elementToBeClickable((passwordField)));

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void clickSaveButton() {
       // WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public static void clickAvatarIcon() {
       // WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar")));
        avatarIcon.click();

    }

    @DataProvider(name="incorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][] {
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}

//Fluent wait example
//FluentWait wait=new FluentWait(LoginTests.drive)
//wait
//.withTimeout(Duration.ofSeconds(10))
//.pollingEvery(Duration.ofSeconds(1))
//.ignoring(Exception.class)