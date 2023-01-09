import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";
    public static String songTitle = "Pluto";
    public static String playlistName = "Sample Playlist";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void openBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    //login
    public static void enterEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
        Thread.sleep(1000);
    }
    public static void enterPassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(1000);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(1000);
    }
    public static void login(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }




    //navigate to All Songs page
    public static void navigateToAllSongs() throws InterruptedException {
        WebElement allSongsPage = driver.findElement(By.cssSelector("a[class='songs']"));
        allSongsPage.click();
        Thread.sleep(1500);
    }
    //select song
    public static void playDesiredSong() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement selectedSong = driver.findElement(By.xpath("//section[@id='songsWrapper']//td[contains(text(), '" + songTitle + "')]"));
        actions.doubleClick(selectedSong).perform();
        Thread.sleep(1000);
        }
    //Validate song is playing
    public boolean validateSongIsPlaying() {
        WebElement soundBarIcon = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        return soundBarIcon.isDisplayed();
    }
}
