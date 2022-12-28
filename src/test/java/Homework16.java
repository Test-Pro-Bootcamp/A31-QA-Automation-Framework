import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    @Test
    public static void Registration() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        // find element-registration
        // click on registration

        WebElement registrationField = driver.findElement(By.cssSelector("[id='hel']"));
        registrationField.click();

        WebElement newaccField = driver.findElement(By.className("login-wrapper"));
        Assert.assertTrue(newaccField.isDisplayed);

        driver.quit();
    }
}
