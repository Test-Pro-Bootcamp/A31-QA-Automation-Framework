import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 extends BaseTest{

@Test
public static void Navigation() {


    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url = "http://bbb.testpro.io/";
    driver.get(url);

    WebElement registration = driver.findElement(By.cssSelector("a[id='hel']"));
    registration.click();

    WebElement userAvatar = driver.findElement(By.xpath(("/html/body/div/hs")));
    Assert.assertTrue(userAvatar.isDisplayed());

    driver.quit();

}
}
