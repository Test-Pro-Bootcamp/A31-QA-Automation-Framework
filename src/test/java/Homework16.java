import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    static void Navigation() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";

        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("#hel"));
        registrationLink.click();

        WebElement verifyRegistrationButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(verifyRegistrationButton.isDisplayed());

        driver.quit();
    }

}
