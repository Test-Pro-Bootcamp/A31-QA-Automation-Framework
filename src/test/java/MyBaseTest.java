import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class MyBaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public static void closeBrowser(){
       driver.quit();
    }

    public void navigateToPage(){
        driver.get(url);
    }


    public  void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public  void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public  void providePassword(String password) {
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

    //new methods here


    // search a song
    public static void searchSong(String songTitle) {

        WebElement searchSongField = driver.findElement(By.cssSelector("[type='search']"));
        Assert.assertTrue(searchSongField.isDisplayed());
        searchSongField.click();
        searchSongField.sendKeys(songTitle);
    }

public static void clickviewAll (){
    WebElement viewAllField = driver.findElement(By.cssSelector("[data-test=view-all-songs-btn]"));
    viewAllField.click();
}
public static void addField () {
    WebElement addField = driver.findElement(By.cssSelector(".search-results > .virtual-scroller tr:nth-of-type(1)"));
    addField.click();
}
    public static void addToField() {
        WebElement addToField = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToField.click();
    }

    public static void verifyAddField () {
        WebElement verifyAddField = driver.findElement(By.cssSelector(" li.playlist.playlist:nth-child(3)"));
        verifyAddField.click();
    }

    public static void songField(){
        WebElement songField = driver.findElement(By.cssSelector(".playlist.song-list-wrap > .virtual-scroller .title"));
        Assert.assertTrue(songField.isDisplayed());

    }

}




