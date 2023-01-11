import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public  class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;


    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public static void breakDownBrowser() {
        driver.quit();
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);

    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public static void logIn(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public static void verifyLogIn() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        assertTrue(avatarIcon.isDisplayed());
    }

    @DataProvider(name = "incorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][]{
                {"invalidemail@email.com", "invalidPass"},
                {"demo@mail.com", "invalid"},
                {"", ""}};
    }
}




