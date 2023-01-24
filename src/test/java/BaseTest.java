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
import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;

    public FluentWait fluentWait = null;
    public Actions actions = null;

    @BeforeSuite
    public void setupClass() {
        //  WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
    }

    @AfterMethod
    public void closeBrowser() {
        LoginTests.driver.quit();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities dCaps = new DesiredCapabilities();
        String gridURL= "http://192.168.0.23:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "grid-firefox":
                dCaps.setCapability("browserName", "firefox");
                driver =new RemoteWebDriver(URI.create(gridURL).toURL(),dCaps);
                break;
            case "grid-edge":
                dCaps.setCapability("browserName", "MicrosoftEdge");
                driver =new RemoteWebDriver(URI.create(gridURL).toURL(),dCaps);
                break;
            case "grid-chrome":
                dCaps.setCapability("browserName", "chrome");
                driver =new RemoteWebDriver(URI.create(gridURL).toURL(),dCaps);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
        }
        return driver;
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
        WebElement passwordField = LoginTests.driver.findElement(By.cssSelector("[type='password']"));
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
        WebElement saveButton = LoginTests.driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName) {
        WebElement profileName = LoginTests.driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = LoginTests.driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = LoginTests.driver.findElement(By.cssSelector("img.avatar"));
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
