import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 {

    @Test
    public static void Navigation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String url = "https://bbb.testpro.io/";
        String url2 = "https://bbb.testpro.io/registration.php";
        driver.get(url);
        Thread.sleep(2000);

        WebElement registrationButton = driver.findElement(By.cssSelector("a[id=hel]"));
        registrationButton.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.cssSelector("[id='email']"));
        emailField.click();
        Thread.sleep(2000);

        emailField.sendKeys("TestTest@email.com");
        Thread.sleep(2000);

        WebElement registerButton = driver.findElement(By.cssSelector("input[id=button]"));
        Thread.sleep(2000);

        registerButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(),url2);
        driver.quit();
    }
}
