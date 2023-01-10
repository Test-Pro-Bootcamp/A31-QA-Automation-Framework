import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework16 {
    @Test
    public static void registration(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url="https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationButton = driver.findElement(By.id("[id='hel']"));
registrationButton.click();

//WebElement emailField =driver.findElement(By.cssSelector("[type='email']"));
//emailField.click();
//emailField.sendKeys("demo@class.com");

WebElement registerButton =driver.findElement(By.id("[id='button']"));
        Assert.assertTrue(registerButton.isDisplayed());

        driver.quit();


    }
}
