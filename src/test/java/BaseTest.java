import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;



public class BaseTest {

    public static String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Parameters("BaseUrl")
    public static void navigateToPage() {
        driver.get(url);
    }

    public static WebDriver driver;

    @BeforeMethod
    @Parameters("BaseURL")
    public void launchBrowser(String BaseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod

    public static void closeBrowser() {
        driver.quit();
    }

    public void login(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePasssword(password);
        clickSubmit();
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


    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = Homework18.driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(1000);
    }
    public static void playSong() throws InterruptedException {
        WebElement playButton = driver.findElement(By.cssSelector("div span.cover"));
        playButton.click();
        Thread.sleep(2000);
    }
    public static void verifyPlayingSong() {
        WebElement soundBar = driver.findElement(By.cssSelector("div > button:nth-child(2) > div"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
   

