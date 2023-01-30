import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public  class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions;



    @BeforeMethod
    @Parameters({"baseURL"})
    public static void setUpBrowser(String baseURL) throws MalformedURLException {
        driver = pickBrowser("firefox");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        actions = new Actions(driver);
    }

    @AfterMethod
    public static void breakDownBrowser() {
        driver.quit();
    }

    public static WebDriver pickBrowser(String brwsr) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.168:4444";
        switch (brwsr) {
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                return driver = new FirefoxDriver();
            }
            case "MicrosoftEdge" -> {
                return driver = new EdgeDriver();
            }
            case "grid-firefox" -> {
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-edge" -> {
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            default -> {
                return driver = new ChromeDriver();
            }
        }
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);

    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public static void logIn(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void verifyLogIn() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        assertTrue(avatarIcon.isDisplayed());
    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][]{
                {"invalidemail@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}};
    }
}




