import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";
    public static WebDriverWait wait;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void openBrowser(String BaseURL) {
        driver = new ChromeDriver();
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //login -- base
    public static void login(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    //Create Playlist -- base
    public static void createPlaylist(String playlistName) {
        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[class='fa fa-plus-circle create']")));
        plusButton.click();

        WebElement newPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistButton.click();

        WebElement newPlaylistField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        newPlaylistField.sendKeys(playlistName);
        newPlaylistField.submit();

        WebElement customPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]")));
        Assert.assertTrue(customPlaylist.isDisplayed());
    }

    //Add song to playlist -- Homework17
    public static void addSongToThePlaylist(String songTitle, String playlistName) {
        WebElement clickAllSongs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'All Songs')]")));
        clickAllSongs.click();

        WebElement clickSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(),'"+songTitle+"')]")));
        clickSong.click();

        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
        addToButton.click();

        WebElement clickPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@class='existing-playlists']//li[contains(text(),'"+playlistName+"')]")));
        clickPlaylistName.click();
    }
    //Validate song is added -- Homework17
    public static boolean songIsAddedMsg() {
        WebElement songIsAddedPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return songIsAddedPopup.isDisplayed();
    }

    //play song -- Homework18
    public static void playSelectedSong(String songTitle) {
        WebElement allSongsPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='songs']")));
        allSongsPage.click();

        Actions actions = new Actions(driver);
        WebElement selectedSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//td[contains(text(), '" + songTitle + "')]")));
        actions.doubleClick(selectedSong).perform();
    }
    //Validate song is playing -- Homework18
    public static boolean validateSongIsPlaying() {
        WebElement soundBarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        return soundBarIcon.isDisplayed();
    }

    //deleted playlist -- Homework19
    public static void deleteEmptyPlaylist(String playlistName) {
        WebElement customPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+playlistName+"')]")));
        customPlaylist.click();

        WebElement clickDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='del btn-delete-playlist']")));
        clickDelete.click();
    }
    //confirm playlist is deleted
    public static boolean isDeleted() {
        WebElement isDeletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']//div[contains(text(), 'Deleted playlist')]")));
        return isDeletedMessage.isDisplayed();
    }
}
