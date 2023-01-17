import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static FluentWait fluentWait = null;
    public static Actions action = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        LoginTests.driver = new ChromeDriver();
//        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
        action = new Actions(driver);

    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }

    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

   public static void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public  static void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    public static void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));// use this when method only take WebElement

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void homePage(){
        WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homePage.click();
    }
    public static void playLists(){
        WebElement playLists = driver.findElement(By.xpath("//h1[contains(text(),'Playlists')]"));
        playLists.isDisplayed();
    }
    public static void choosePlaylist(){
<<<<<<< Updated upstream
        WebElement choosePlaylist = driver.findElement(By.xpath("//a[contains(text(),'rock songs')]"));
        choosePlaylist.click();
=======
//        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist.playlist:nth-child(8) > a:nth-child(1)")));
//        playlistElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
>>>>>>> Stashed changes
    }
    public static void deletePlaylist(){
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deletePlaylist.click();
<<<<<<< Updated upstream
=======
    }
    public static void contextClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']")));
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Edit')]")));
    }
    public static void playlistNewName(){
      //  WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        WebElement playlistInputField = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("newPlaylist");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public static void doubleClickPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(playlistElement).perform();
    }
    public static void enterPlaylistName(){
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Cool");
        playlistInputField.sendKeys(Keys.ENTER);
    }
//    public static boolean doesPlaylistExist(){
//        WebElement playlistElement = driver.findElement(By.xpath("//a[text()="Edited Playlist Name']"));
//        return playlistElement.isDisplayed();
//    }
    public static boolean IsPlaylistRenamed(){
     //   WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement playlistElement = driver.findElement(By.xpath("//a[contains(text(),'Cool')]"));
        return playlistElement.isDisplayed();
>>>>>>> Stashed changes
    }
    public static void pressOk(){
        WebElement pressOk = driver.findElement(By.cssSelector("button.ok"));
        pressOk.click();
    }
    public static boolean playlistIsDeleted(){

        WebElement playlistIsDeleted = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return true;
    }
    public static void mostPlayed() {
        WebElement mostPlayed = driver.findElement(By.xpath("//h1[contains(text(),'Most Played')]"));
        mostPlayed.isDisplayed();
    }
    public static void playSong() {
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
    }
    public boolean songIsPlaying(){
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid= 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();
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

    @DataProvider(name="incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {

        return new Object[][] {
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}
