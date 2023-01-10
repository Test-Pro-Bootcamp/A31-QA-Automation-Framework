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

import static org.testng.Assert.assertTrue;

public  class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseURL);
    }
    @AfterMethod
    public void breakDownBrowser() {
        driver.quit();
    }
    public void logIn(String email, String password){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        assertTrue(avatarIcon.isDisplayed());}
}

