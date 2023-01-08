import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public static WebDriver driver = null;
    static String url="null";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);

    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type=submit]"));
        submitButton.click();
    }

    public static void login(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type ='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

//    public static void navigateToPage() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public static String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
        //this is getting a random userid and removing dashes
    }

    public static void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public static void provideProfileName(String randomName) {
        WebElement profilename = driver.findElement(By.cssSelector("[name='name']"));
        profilename.clear();
        profilename.sendKeys(randomName);
    }

    public static void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public static void clickavatarIcon() {
        WebElement avatarIcon= driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    @DataProvider(name="incorrectLoginProviders")
    public static Object[][] getDataFromDataproviders() {
        return new Object[][]{
                {"invalid@email.com", "nothing"},
                {"demo@mail.com", "invalid"},
                {"", ""}
        };
    }

    public void playSong() {
        WebElement nextSongBtn = driver.findElement(By.xpath("//i[@data-test='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        nextSongBtn.click();
        playBtn.click();
    }

    public void isSongPlaying() {
            WebElement soundBar=driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            Assert.assertTrue(soundBar.isDisplayed());
        }
}


