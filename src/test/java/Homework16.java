import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 {
    // public static WebDriver driver = null;
    // public static String url = null;
    @Test
    public static void Navigation() {
        System.setProperty("webdriver.chrome.driver","c:\\\\chromedriver\\chromedriver.exe");
        String url = "https://bbb.testpro.io/";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        WebElement registration = driver.findElement(By.id("hel"));
        registration.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://bbb.testpro.io/registration.php" );
        driver.quit();
    }
}
