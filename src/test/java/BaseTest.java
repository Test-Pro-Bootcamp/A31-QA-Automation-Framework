import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
public class BaseTest {
    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
        WebDriver driver;

    @BeforeMethod
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}
    public void openLoginURL() {
        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void enterEmail() {
            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("skyeman75@gmail.com");
        }
        public void enterPassword() {
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");
        }
        public void clickButton() {
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
        }
        @BeforeMethod
    public void breakDownBrowser(){
    driver.quit();
    }
}

