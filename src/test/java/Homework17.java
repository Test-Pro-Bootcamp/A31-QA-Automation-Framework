import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class Homework17 extends BaseTest {


    @Test
    public void addSongtoPlaylist () throws InterruptedException {
        openloginUrl();
        enterEmail("jenyag5@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();

        WebDriver driver;


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        public void openloginUrl() {
        driver.get("http://bbb.testpro.io/");
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
        public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        }
        }