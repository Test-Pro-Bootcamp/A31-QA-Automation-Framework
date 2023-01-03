import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";
    String email = "test123@test.com";
    String password = "te$t$tudent";
    String songTitle = "Frantic";
    String playlistName = "HW17";


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

    //Open login page
    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    //Log In
    public void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
        Thread.sleep(1000);
    }

    public void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
    }

    public void avatarIcon() throws InterruptedException {
        WebElement userAvatar = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(userAvatar.isDisplayed());
        Thread.sleep(2000);
    }

    public void login() throws InterruptedException {
        provideEmail("test123@test.com");
        providePassword("te$t$tudent");
        clickSubmit();
        avatarIcon();
        Thread.sleep(2000);
    }

    //Create Playlist
    public void plusIcon() throws InterruptedException {
        WebElement clickPlusButton = driver.findElement(By.cssSelector("i[class='fa fa-plus-circle create']"));
        clickPlusButton.click();
        Thread.sleep(500);
    }

    public void newPlaylistButton() throws InterruptedException {
        WebElement clickNewPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        clickNewPlaylistButton.click();
        Thread.sleep(500);
    }

    public void createPlaylistName(String playlistName) throws InterruptedException {
        WebElement newPlaylistField = driver.findElement(By.cssSelector("input[name='name']"));
        newPlaylistField.sendKeys(playlistName);
        newPlaylistField.submit();
        Thread.sleep(1000);
    }

    public void confirmCreatedPlaylist() throws InterruptedException {
        WebElement customPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]"));
        Assert.assertTrue(customPlaylist.isDisplayed());
        Thread.sleep(1000);
    }

    public void createPlaylist() throws InterruptedException {
        plusIcon();
        newPlaylistButton();
        createPlaylistName(playlistName);
        confirmCreatedPlaylist();
    }

    //Click All Songs tab
    public void allSongs() throws InterruptedException {
        WebElement songs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        songs.click();
        Thread.sleep(2000);
    }

    //Select a song
    public void selectSong() throws InterruptedException {
        WebElement clickSong = driver.findElement(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(), '" + songTitle + "')]"));
        clickSong.click();
        Thread.sleep(1000);
    }

    //Click AddTo button
    public void addTo() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
        Thread.sleep(1000);
    }

    //Select the existing playlist
    public void selectPlaylist() throws InterruptedException {
        WebElement clickPlaylistName = driver.findElement(By.xpath("//section[@class='existing-playlists']//li[contains(text(), '" + playlistName + "')]"));
        clickPlaylistName.click();
        Thread.sleep(2000);
    }

    //Add song to the playlist
    public void addSongToThePlaylist() throws InterruptedException {
        allSongs();
        selectSong();
        addTo();
        selectPlaylist();
    }

    //navigate to the playlist
    public void navigateToPlaylist() throws InterruptedException {
        WebElement goToPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(), '" + playlistName + "')]"));
        goToPlaylist.click();
        Thread.sleep(2000);
    }

    //Confirm the song is added
    public void confirmSongIsAdded() throws InterruptedException {
        WebElement confirmSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), '" + songTitle + "')]"));
        Assert.assertTrue(confirmSong.isDisplayed());
        Thread.sleep(2000);
    }

    public void validateTheSongIsAdded() throws InterruptedException {
        navigateToPlaylist();
        confirmSongIsAdded();
    }
}
