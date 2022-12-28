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

        String url = "http://bbb.testpro.io/";
        driver.get(url);

        WebElement registration = driver.findElement(By.cssSelector("a[id='hel']"));
        registration.click();

        WebElement usersAvatar = driver.findElement(By.cssSelector(("[class='login-wrapper']")));
        Assert.assertTrue(usersAvatar.isDisplayed());

        driver.quit();

        }
      }