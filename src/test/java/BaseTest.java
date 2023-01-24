import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver driver;
    public static WebDriverWait wait = null;


    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        driver = pickBrowser(System.getProperty("browser"));
        driver.get(BaseURL);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
//        Homework17.driver = new ChromeDriver();
//        Homework17.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(10));
//        driver.get(BaseURL);
    }

    @AfterMethod
    public static void closeBrowser() {
        Homework17.driver.quit();
    }

    private static WebDriver pickBrowser(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }

    protected static void navigateToTestPro() {
        String url = "http://bbb.testpro.io/";
        driver.get(url);
    }

    public static void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
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


