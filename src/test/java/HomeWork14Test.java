import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class HomeWork14Test extends BaseTest {
    @Test
    public static void navigation() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("a[type = submit]"));
        registrationLink.click();
        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);
        driver.quit(); }
}