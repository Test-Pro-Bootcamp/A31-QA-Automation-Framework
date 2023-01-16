import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class Homework16 extends BaseTest {
    @Test
    public static void registrationTest() {

        // Precondition: Chrome browser should be opened
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Step1. Open koel login page
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Step2. Click to Registration
        //find registration
        WebElement registration = driver.findElement(By.cssSelector("a[id]"));
        // click into registration
        registration.click();

        //Step3. Validate that you are redirected to registration page

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));

        Assert.assertTrue(emailField.isDisplayed());
driver.quit();

    }
}
