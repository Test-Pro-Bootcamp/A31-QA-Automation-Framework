import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.UUID;


public class BaseTest {
    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;

    public Actions action = null;
    public ThreadLocal<WebDriver> threadDriver = null;

    //@BeforeSuite
    //static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    //}

    @BeforeMethod
    @Parameters("BaseUrl")
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        url = BaseUrl;

        threadDriver=new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));

        threadDriver.set(driver);



      wait = new WebDriverWait(getDriver(),Duration.ofSeconds(20));

        action = new Actions(getDriver());
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
        DesiredCapabilities dCap = new DesiredCapabilities();
        String gridURI = "http://192.168.86.32:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();

               case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();

                case "grid-edge":
                dCap.setCapability("browserName", "MicrosoftEdge");
               return driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);

               case "grid-firefox":
                dCap.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);

                case "grid-chrome":
                dCap.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURI).toURL(), dCap);

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
        ltOptions.put("user", "shalinibaronia");
        ltOptions.put("accessKey", "fPH3tVYv2I2ZMOQGbtMgkKRXMVoMIN4ya76moFRzQkigGFIOn8");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }

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
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }


    public void clickAvatarIcon() {
        WebElement avatarIcon = getDriver().findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = getDriver().findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
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


}