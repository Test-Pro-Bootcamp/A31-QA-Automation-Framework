import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

import static java.lang.Thread.sleep;

public class Homework17 extends BaseTest {

    @Test
    public static void AddSongToPlaylist () throws InterruptedException {


            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            Thread.sleep(2000);
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);
            driver.quit();

        WebElement Emailfield = driver.findElement(By.cssSelector("[type ='email']"));
        Emailfield.click();
        Emailfield.sendKeys("tatsianahuryeva@yahoo.com");

        WebElement PasswordField = driver.findElement(By.cssSelector("[type = 'password']"));
        PasswordField.click();
        PasswordField.sendKeys("te$t$tudent");

        WebElement Button = driver.findElement(By.cssSelector("button[type = 'submit']"));
        Button.click();

    }
}
