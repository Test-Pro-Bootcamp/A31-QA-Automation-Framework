import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework14
{




    @Test

        public static void navigation() {

        WebDriver register = new ChromeDriver();
        register.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        register.get(url);

        String registrationLink = "#hel";
        register.findElement(By.cssSelector(registrationLink)).click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(register.getCurrentUrl(), registrationUrl);
        register.quit();


    }


    }








