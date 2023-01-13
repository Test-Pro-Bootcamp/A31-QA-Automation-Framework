import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    static void setupClass() { WebDriverManager.chromedriver().setup();}
    public static void navigateToPage() {
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
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }


    //Methods below used for Homework17 class
     public static String generateRandomName() {
        return UUID.randomUUID().toString().replace("-" , "");

        }
    public static void login(String email,String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();

    }
    public static void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(3000);
    }

    public static void viewAllSearchResults() throws InterruptedException {
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResults.click();
    Thread.sleep(3000);
    }

    public static void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        selectFirstSongResult.click();
        Thread.sleep(3000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(3000);

    }

    public static void choosePlaylist(String playlistName) throws InterruptedException{
        WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/il[contains(text(),'"+playlistName+"')]"));
        playlistNameElement.click();
        Thread.sleep(3000);
    }

    public boolean isNotificationPopUpPresent() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }

    @BeforeMethod //Opening Chrome Browser
    public void launchBrowser() {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod   //Quiting the driver after every method
    public static void closeBrowser () {
            LoginTests.driver.quit();

        //***Disregard this method no longer being used.***

//    public static void grabASong() {
//        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']")));
//        WebElement playlist = driver.findElement(By.xpath("//li/a[contains(@href,'#!/playlist/35439'"));
//        Actions acts = new Actions(driver);
//        acts.clickAndHold(song).moveToElement(playlist).release(playlist).build().perform();
        //  }

        //***Disregard this method no longer being used.***

        // public static void addSong(){;
        //    Assert.assertTrue(isSongAdded(songTitle), message: "Song titled" +songTitle+ "added to playlist");
        //  driver.quit();
        //}
    }
}
