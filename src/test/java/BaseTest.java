import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    private static WebDriver WebDriverReference;
    private static Duration Timeout;
    public static WebDriverWait wait;
    public static String url = null;


    //@BeforeSuite
    //static void setupClass() {
        //WebDriverManager.chromedriver().setup();
   // }

//    WebDriver driver;
    //WebDriverWait wait;
//    String url;
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(4) );
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
    public void searchSong(String songTitle) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("//input[@placeholder='Press F to search']"));
        searchField.sendKeys(songTitle);
        searchField.click();
        Thread.sleep(2000);
    }
    public void grabASong() {
        WebElement song = driver.findElement(By.xpath("article[title='Simon Mathewson by Music Insiders By Fma'] a[class='name']"));
        WebElement playlist = driver.findElement(By.xpath("a[class='active']"));

        Actions acts = new Actions(driver);
        acts.clickAndHold(song)
                .release(playlist)
                .build()
                .perform();

        playlist.click();
    }
    public void viewAllSearchResults() throws InterruptedException{
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn"));
        viewAllSearchResults.click();
        Thread.sleep(2000);

        clickAddToButton();
        Thread.sleep(2000);
    }
    public static void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }

    public static void selectSong(String simonMathewson) throws InterruptedException {
        WebElement selectSong = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] tr:nth-child(2) td:nth-child(1)"));
        selectSong.click();
        Thread.sleep(2000);


    }
    public void selectPlaylistname(String playlistName) throws InterruptedException {
        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[5]"));

        selectPlaylist.click();
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
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
