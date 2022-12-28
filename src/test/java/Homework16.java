import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    @Test

    public static void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement clickRegistration = driver.findElement(By.cssSelector("[id='hel']"));
        clickRegistration.click();

        WebElement registrationEmail = driver.findElement(By.cssSelector("[id='email']"));
        Assert.assertTrue(registrationEmail.isDisplayed());
        driver.quit();


    }
}
