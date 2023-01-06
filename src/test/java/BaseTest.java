import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser() {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser() {
        LoginTests.driver.quit();
    }

    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
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

    public static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }

    //Click All Songs tab
    public void allSongs() throws InterruptedException {
        WebElement songs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        songs.click();
        Thread.sleep(2000);
    }

    //Select a song and play
    public void playSelectedSong() throws InterruptedException {
        String songTitle = "Dark Days";
        Actions playDesiredSong = new Actions(driver);
        WebElement selectSong = driver.findElement(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + songTitle + "')]"));
        playDesiredSong.doubleClick(selectSong).perform();
        Thread.sleep(2000);
    }

    //Validate the song is playing
    public void validateSongIsPlaying() throws InterruptedException {
        WebElement soundEqualiserBars = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Assert.assertTrue(soundEqualiserBars.isDisplayed());
        Thread.sleep(2000);
    }
}
