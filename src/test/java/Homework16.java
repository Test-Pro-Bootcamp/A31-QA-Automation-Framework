import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public static void registration () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "http://bbb.testpro.io";
        driver.get(url);

        driver.findElement(By.cssSelector("a[type='Submit']")).click();
        WebElement registrationButton = driver.findElement(By.cssSelector("[type='email']"));
        Assert.assertTrue(registrationButton.isDisplayed());

        driver.quit();
    }

}