import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Timeout;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static String url = "https://bbb.testpro.io/";
    ThreadLocal<WebDriver> driverThread;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        driverThread = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        driverThread.set(driver);

//        action = new Actions(getDriver());
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().get(BaseURL);

    }

    public WebDriver getDriver(){
        return driverThread.get();
    }

    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
        driverThread.remove();
    }
    public WebDriver lambdaTest() throws MalformedURLException{

        String username = "anupapeter01";
        String authkey = "UaDrDuSOMhtyKB69rOF47N2HJfpXcHolN69Ri3llnjNu2xjneK";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName","Chrome");
        caps.setCapability("version","109.0");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username","anupapeter01");
        ltOptions.put("accessKey","UaDrDuSOMhtyKB69rOF47N2HJfpXcHolN69Ri3llnjNu2xjneK");
        ltOptions.put("project","Testing");
        ltOptions.put("selenium-version","4.0.0");
        ltOptions.put("w3c", true);
        caps.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver((new URL("https://"+ username +":"+ authkey + hub)), caps);

    }

    public WebDriver pickBrowser(String brwsr) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String gridURL = "http://10.0.0.231:4444";
        switch(brwsr) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome","":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "grid-firefox":
                cap.setCapability("browserName","firefox");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
                break;
            case "grid-edge":
                cap.setCapability("browserName","MicrosoftEdge");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
                break;
            case "grid-chrome":
                cap.setCapability("browserName","chrome");
                driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
                break;
            case "cloud":
                return lambdaTest();
        }
        return driver;
    }

    public static void navigateToPage()
    {
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }
    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-submit")));
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public static void clickAvatarIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.avatar")));
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}
