import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
@BeforeSuite
static void setupClass(){

    WebDriverManager.chromedriver().setup();
}

    @BeforeMethod
    public static void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);
    }

    public static void navigateToPage(String urlAdd) {
        String url = "https://bbb.testpro.io/";
        driver.get(url);

    }

    public static void searchASong(String songTitle) throws InterruptedException {
        WebElement searchSongField = driver.findElement(By.xpath("//header/div[@id='searchForm']/input[1]"));
        searchSongField.click();

        searchSongField.sendKeys(songTitle);

        Thread.sleep(4000);
    }

  public static void viewAllSearchResult() throws InterruptedException {
      WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));


       Thread.sleep(4000);
        viewAllButton.click();
        Thread.sleep(4000);

    }


    public static void selectSong() throws InterruptedException {
        WebElement Song = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] tr:nth-child(2) td:nth-child(1)"));
        Song.click();
        Thread.sleep(2000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));

        addToButton.click();
        Thread.sleep(2000);
    }

    public static void selectPlaylistName() throws InterruptedException {
        WebElement selectPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='Newplaylist']"));
        selectPlaylist.click();
        Thread.sleep(2000);

    }
}




