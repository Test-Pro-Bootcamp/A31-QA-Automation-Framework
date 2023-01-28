import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class MyBaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static FluentWait fluentWait = null;

    //public static WebDriver driver;
    //public static WebDriverWait;
    //public static String url = "https://bbb.testpro.io";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

   // @BeforeMethod
    //@Parameters("baseUrl")
    //public static void launchBrowser(String baseURL) {
       //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.get(url);


        @BeforeMethod
        @Parameters({"BaseURL"})
        public void launchBrowser(String BaseURL) {
            LoginTests.driver = new ChromeDriver();
            LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            url = BaseURL;
            driver.get(url);
            wait = new WebDriverWait(LoginTests.driver, Duration.ofSeconds(20));
        }


    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }


    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public static void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        //Thread.sleep (1000);
    }

    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);

    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

    }

    public void searchSong(String songTitle) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitle);
        searchField.click();
        Thread.sleep(2000);
    }

    public static void viewAllSearchResults() throws InterruptedException{
        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn"));
        viewAllSearchResults.click();
        Thread.sleep(2000);

        clickAddToButton();
        Thread.sleep(2000);
    }

    public static void selectSong() throws InterruptedException {
        WebElement selectSong = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] tr:nth-child(2) td:nth-child(1)"));
        selectSong.click();
        Thread.sleep(2000);


    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.xpath("//button.btn-add-to"));
        addTo.click();
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

    //public boolean isNotificationPopUpPresent() {
    // notificationText = driver.findElement(By.cssSelector("div.success.show"));
    //return notificationText.isDisplayed();
    }

