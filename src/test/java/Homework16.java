import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework16 extends BaseTest {

    @Test(enabled = true, description = "Testregistrationlink")
    public static void Registration() {


        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        String registrationURL = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

    }

@Test(enabled = true, description = "Loginwvalidaccount")
    public static void validLogin (){
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("demo.class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type ='password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type=submit]"));
        submitButton.click();

        WebElement avataricon = driver.findElement(By.cssSelector("img.avatar"));

        Assert.assertTrue(avataricon.isDisplayed());

}
}
