import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.quit();

    }

    @Test
    public static void LoginValidEmailPasswordTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);

        WebElement avatarIcon = driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();

    }

    @Test
    public static void LoginInvalidEmail(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("demoinvalid@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        Assert.assertTrue(emailField.isDisplayed());

        driver.quit();

    }

}
