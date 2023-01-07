import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public static void closeBrowser(){
        LoginTests.driver.quit();
    }

//    protected static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public static void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void clickSubmit(){
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    public static void allSongsPage(){
        WebElement allSongsPage = driver.findElement(By.cssSelector("a.songs"));
        allSongsPage.click();
    }
    public static void firstSong(){
        WebElement firstSong = driver.findElement(By.xpath("//td[contains(text(),'HoliznaCC0 - Waiting On A Train')]"));
        firstSong.click();
    }
    public static void addSongTo(){
        WebElement addSongTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addSongTo.click();
    }
    public static void firstPlaylist(){
        WebElement firstPlaylist = driver.findElement(By.xpath("//section[3]/header[1]/div[3]/div[1]/section[1]/ul[1]/li[5]"));
        firstPlaylist.click();
    }
    public static void validatePlaylist() {
        WebElement validatePlaylist = driver.findElement(By.cssSelector("div.success.show"));
        validatePlaylist.isDisplayed();
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

    @DataProvider(name="incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {

        return new Object[][] {
                {"invalid@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }
}
