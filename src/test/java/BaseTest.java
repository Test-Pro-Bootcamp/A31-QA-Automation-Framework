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

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    WebDriver driver;
    String email = "hand923@gmail.com";
    String password = "te$t$tudent";
    String songTitle = "Reactor";
    String playlistName = "Sample Playlist";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //Open login page
    public void openLogUrl() {
        String url = "http://bbb.testpro.io";
        driver.get(url);
    }
    //login
    public void enterEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
        Thread.sleep(1000);
    }
    public void enterPassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
        Thread.sleep(1000);
    }
    public void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(1000);
    }
    //"combine" login
    public void login() throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    //Create Playlist
    public void clickPlusButton() throws InterruptedException {
        WebElement plusButton = driver.findElement(By.cssSelector("i[class='fa fa-plus-circle create']"));
        plusButton.click();
        Thread.sleep(500);
    }
    public void clickNewPlaylistButton() throws InterruptedException {
        WebElement newPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButton.click();
        Thread.sleep(500);
    }
    public void inputPlaylistName(String playlistName) throws InterruptedException {
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
    //"combine" Create playlist
    public void createPlaylist() throws InterruptedException {
        clickPlusButton();
        clickNewPlaylistButton();
        inputPlaylistName(playlistName);
        confirmCreatedPlaylist();
    }

    //Add song to playlist
    public void navigateToAllSongs () throws InterruptedException {
        WebElement clickAllSongs = driver.findElement(By.xpath("//a[contains(text(), 'All Songs')]"));
        clickAllSongs.click();
        Thread.sleep(1000);
    }
    public void selectSong () throws InterruptedException {
        WebElement clickSong = driver.findElement(By.xpath("//section[@id='songsWrapper']//table[@class='items']//td[contains(text(),'"+songTitle+"')]"));
        clickSong.click();
        Thread.sleep(1000);
    }
    public void addTo() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
        Thread.sleep(1000);
    }
    public void selectPlaylist () throws InterruptedException {
        WebElement clickPlaylistName = driver.findElement(By.xpath("//section[@class='existing-playlists']//li[contains(text(),'"+playlistName+"')]"));
        clickPlaylistName.click();
        Thread.sleep(1000);
    }
    //"combine" Add song to playlist
    public void addSongToThePlaylist() throws InterruptedException {
        navigateToAllSongs();
        selectSong();
        addTo();
        selectPlaylist();
    }

    //Validate song is added
    public void navigateToCustomPlaylist() throws InterruptedException {
        WebElement customPlaylist = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'"+playlistName+"')]"));
        customPlaylist.click();
        Thread.sleep(1000);
    }
    public void confirmAddedSong() throws InterruptedException {
        WebElement confirmSongTitle = driver.findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(), '"+songTitle+"')]"));
        Assert.assertTrue(confirmSongTitle.isDisplayed());
        Thread.sleep(1000);
    }
    //"combine" Validate song is added
    public void validateSongIsAdded () throws InterruptedException {
        navigateToCustomPlaylist();
        confirmAddedSong();
    }
}
