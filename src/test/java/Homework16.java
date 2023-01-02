import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public static void registrationNav(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement regLink = driver.findElement(By.cssSelector("a[href='/registration.php'"));
        regLink.click();

        WebElement headerText = driver.findElement(By.cssSelector("h2[contains(text(),'Register new account')]"));
        Assert.assertTrue(headerText.isDisplayed());

        driver.quit();
    }
}
