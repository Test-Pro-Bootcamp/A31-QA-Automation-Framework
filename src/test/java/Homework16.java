import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

        @Test
    public static void RegistrationButton() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement RegistrationButton = driver.findElement(By.id("hel"));
        RegistrationButton.click();
        String url2 = "https://bbb.testpro.io/registration.php";
        driver.get(url2);
        //my homework16
    }
}
