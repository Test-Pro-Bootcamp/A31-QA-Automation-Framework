import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {

    public WebDriver driver = null;
    public String url = null;
    public WebDriverWait wait = null;
    public FluentWait fluentWait = null;
    public Actions actions = null;
    public ThreadLocal<WebDriver> threadLocal = null;

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        url = BaseURL;
        threadLocal = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadLocal.set(driver);

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public WebDriver getDriver() {

        return threadLocal.get();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        threadLocal.remove();
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.252:4444";
        switch (browser) {
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
        }
//        return driver;
//        public void tearDownBrowser() {
//            getDriver().quit();
//            threadDriver.remove();
//        }
        return null;
    }


    protected void navigateToTestPro() {
        String url = "http://bbb.testpro.io/";
        driver.get(url);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "amandaag39";
        String authkey = "49PivqN0RpHM4zjvL2JPJDjCAVUoeFeg9MAWYUguESCCVD6OSC";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("108.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "amandaag39");
        ltOptions.put("accessKey", "49PivqN0RpHM4zjvL2JPJDjCAVUoeFeg9MAWYUguESCCVD6OSC");
        ltOptions.put("video", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

//    public static void clickAddButton () {
////        WebElement createPlaylist = driver.findElement(By.cssSelector("i.fa.fa-plus-circle"));
//        WebElement createPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.fa.fa-plus-circle")));
//        createPlaylist.click();
//    }

//    public static void selectNewPlaylistFromDropdown() {
//        WebElement NewPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
//        NewPlaylist.click();
//    }

//    public static void createXYZPlaylist() {
//        WebElement playlistTextField = driver.findElement(By.cssSelector("input[type='text'][name='name']"));
//        playlistTextField.click();
//        playlistTextField.sendKeys("XYZ Playlist" + Keys.ENTER);
//    }

//    public static void confirmXYZPlaylist() {
////        WebElement addNewPlaylist = driver.findElement(By.xpath("//a[text()='XYZ Playlist']"));
//        WebElement addNewPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='XYZ Playlist']")));
//        Assert.assertTrue(addNewPlaylist.isDisplayed());
//    }

//    public static void navigateToAllSongsPage () {
//        String url2="https://bbb.testpro.io/#!/songs";
//        driver.get(url2);
//    }

//    public static void rightClickSong() {
//        Actions rightClick = new Actions(driver);
//        WebElement waitingOnATrainSong = driver.findElement(By.xpath("//*[text()='HoliznaCC0 - Waiting On A Train']"));
////        WebElement waitingOnATrainSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='HoliznaCC0 - Waiting On A Train']")));
//        rightClick.contextClick(waitingOnATrainSong).perform();
//    }

    public void rightClickXYZPlaylist() {
        Actions rightClick = new Actions(driver);
        WebElement xyzPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']"));
        rightClick.contextClick(xyzPlaylist).perform();
    }
}

//    public static void selectXYZPlaylist() {
//        WebElement xyzPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']"));
//        xyzPlaylist.click();
//    }



// }


