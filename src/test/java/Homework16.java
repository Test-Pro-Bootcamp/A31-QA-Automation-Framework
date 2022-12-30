import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void Navigation () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        //Thread. sleep (200);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String registrationURL = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),registrationURL);
        driver.quit();

    }
}
