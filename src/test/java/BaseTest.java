import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
public class BaseTest {
    @BeforeSuite
    public void setupClass() {
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
    public void enterEmail(String email) {
            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys(email);
        }
        public void enterPassword(String password) {
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys(password);
        }
        public void clickButton() {
            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();
        }
        @AfterMethod
    public void breakDownBrowser(){
    driver.quit();
    }
}

