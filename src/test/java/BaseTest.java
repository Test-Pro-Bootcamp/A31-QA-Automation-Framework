import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public static void launchBrowser(String BaseUrl) {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().window().maximize();
        LoginTests.driver.get(BaseUrl);
        wait = new WebDriverWait(LoginTests.driver,Duration.ofSeconds(20));
    }

    @AfterMethod
    public static void closeBrowser() {
        LoginTests.driver.quit();
    }

    protected void login(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));

        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));

        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));
        submitButton.click();
    }
}