import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Homework16 extends BaseTest {

    @Test
    public static void navigation() {

        WebDriver driver = new ChromeDriver();

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registration = driver.findElement(By.cssSelector("[id='hel']"));
        registration.click();

        WebElement register = driver.findElement(By.cssSelector("[id='button']"));
        Assert.assertTrue(register.isDisplayed());
        driver.quit();

    }
}
