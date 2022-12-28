import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LianoHomeworkTests extends BaseTest {

    @Test
    public static void NavigationTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.id("hel"));
        registrationLink.click();

        WebElement registrationButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Register']"));
        Assert.assertTrue(registrationButton.isDisplayed());

        driver.quit();
    }

}