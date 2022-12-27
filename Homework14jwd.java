import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework14jwd(){

    @Test

        public static void navigation() {
        WebDriver register = new WebDriver();
        register.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://testpro.io/";
        register.get(url);

        WebElement registrationLink = register.findElement(By.cssSelector(#hel));

        register.findElement(By.cssSelector(registrationLink)).click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(register.getCurrentUrl(), registrationUrl);
        register.quit();


    }


    }








