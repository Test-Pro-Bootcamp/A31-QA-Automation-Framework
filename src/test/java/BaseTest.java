import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

//    @Parameters("BaseUrl")
//    public static void navigateToPage() {
//        driver.get(url);
//    }

    @BeforeMethod
    @Parameters("BaseURL")
    public void launchBrowser(String BaseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        url =BaseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


        @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
    public static void login(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePasssword(password);
        clickSubmit();
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePasssword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }

    public static void playlistNotExist() {
        WebElement playlistNotExist = wait.until(elementToBeClickable(By.cssSelector("div.alertify-logs.top.right")));
        Assert.assertTrue(playlistNotExist.isDisplayed());
    }

    public static void deleteButton() {
        WebElement deleteButton = wait.until(elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deleteButton.click();
    }

    public static void testPlaylist() {
        WebElement testPlaylist = wait.until(elementToBeClickable(By.xpath("//li/a[text()='test playlist']")));
        testPlaylist.click();
    }
    public static void nameField() {
        String playlistName = "test playlist";
        WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
    }
    public static void newPlaylist() {
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();
    }
    public static void addPlaylist() {
        WebElement addPlayList = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        wait.until(ExpectedConditions.visibilityOf(addPlayList)).click();
    }
//    public static void playSong() throws InterruptedException {
//        WebElement playButton = driver.findElement(By.cssSelector("div span.cover"));
//        playButton.click();
//        Thread.sleep(2000);
//    }
//    public static void verifyPlayingSong() {
//        WebElement soundBar = driver.findElement(By.cssSelector("div > button:nth-child(2) > div"));
//        Assert.assertTrue(soundBar.isDisplayed());
//    }

}

