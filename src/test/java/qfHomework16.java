import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class qfHomework16 extends BaseTest {

    @Test
        public static void Navigation(){

            //Navigate to "https://bbb.testpro.io/"

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            //  Click Registration link
            WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
            registrationLink.click();

            //Validate that you are redirected to Registration page
            String registrationUrl = "https://bbb.testpro.io/registration.php";
            Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

            driver.quit();
        }

    }
