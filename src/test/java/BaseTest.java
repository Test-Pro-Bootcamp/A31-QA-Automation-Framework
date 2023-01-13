import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("BaseUrl")
    public static void launchBrowser(String BaseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BaseUrl);
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    protected void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }

    public void selectPlaylist() throws InterruptedException {
        WebElement openPlaylist = driver.findElement(By.xpath("//a[normalize-space()='Newplaylist']"));
        openPlaylist.click();
        Thread.sleep(2000);
    }

    public void deleteSelectedPlaylist() throws InterruptedException {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylistBtn.click();
        Thread.sleep(2000);
    }
}