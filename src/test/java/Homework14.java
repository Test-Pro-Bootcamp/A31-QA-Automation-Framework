import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework14 extends BaseTest {

    @Test
    public static void Navigation() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement loginField = driver.findElement(By.cssSelector("[type='submit'"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
        /*WebElement avatar = driver.findElement(By.className("avatar"));*/

        driver.quit();


    }

}
