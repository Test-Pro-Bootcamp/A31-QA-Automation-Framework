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
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public static void launchBrowser(String BaseUrl) {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(url);
    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }



    protected static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void login(String email, String password) {
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

    public static void allSongsPage(){
        WebElement allSongsPageNavigate = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongsPageNavigate.click();
    }

    public static void addSongButton(){
        WebElement addSongButtonNavigate = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addSongButtonNavigate.click();
    }

    public static void addToPlaylist(){
        WebElement addToPlaylistNavigate = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        addToPlaylistNavigate.click();
    }
}
