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
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public  WebDriver driver;
    public  String url = "https://bbb.testpro.io/";
    public  WebDriverWait wait = null;
    public  Actions action;
    public ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        url = BaseUrl;
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        action = new Actions(getDriver());
        getDriver().get(url);

    }

    @AfterMethod
    public  void closeBrowser() {
       getDriver().quit();
       threadDriver.remove();
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    private  WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.160:4444";
        switch (browser) {
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            default:
                WebDriverManager.chromedriver().setup();
                ;
                return driver = new ChromeDriver();
        }
    }

    public void login() {
        provideEmail();
        providePassword();
        clickSubmitButton();
    }

    public void provideEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("sandra.geche@gmail.com");
    }

    public void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit"));
    }

    public void validateHomepage() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void addPlaylist() {
        WebElement addPlayList = driver.findElement(By.xpath("//*[@class='fa fa-plus-circle create']"));
    }

    public void newPlaylist() {
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@data-testid='playlist-context-menu-create-simple']"));

    }

    public void namePlaylist() {
        WebElement namePlaylist = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        namePlaylist.clear();
        namePlaylist.click();
        namePlaylist.sendKeys("best songs");
        namePlaylist.sendKeys(Keys.ENTER);
    }

    public void doubleClickToPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(webElement).perform();
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

    public void newPlaylistName() {
        WebElement enterName = driver.findElement(By.cssSelector("input[name='name']"));
        enterName.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        enterName.sendKeys("Wild dream");
        enterName.sendKeys(Keys.ENTER);
    }
}
