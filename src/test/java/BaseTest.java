import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    @BeforeMethod //Opening Chrome Browser
    public void launchBrowser() {
        LoginTests.driver = new ChromeDriver();
        LoginTests.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod   //Quiting the driver after every method
    public static void closeBrowser () {
        LoginTests.driver.quit();
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
