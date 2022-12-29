import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< Updated upstream
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
=======
import org.testng.Assert;
>>>>>>> Stashed changes
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
<<<<<<< Updated upstream
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";

=======


public class BaseTest {
    WebDriver driver;
    String email = "hand923@gmail.com";
    String password = "te$t$tudent";
    String songTitle = "Reactor";
    String playlistName = "Sample Playlist";
>>>>>>> Stashed changes

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
<<<<<<< Updated upstream
    public static void launchBrowser() {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }

    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
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

    public static void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }

    public static void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();

    }
}
=======
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        }


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
    //login "combine method"
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
    //Create playlist "combine method"
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
    //Add song to playlist "combine method"
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
    //Validate song is added "combine method"
    public void validateSongIsAdded () throws InterruptedException {
        navigateToCustomPlaylist();
        confirmAddedSong();
    }
    }
>>>>>>> Stashed changes
