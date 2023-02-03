import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {
        // Simple comment
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        Thread.sleep(2000);
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public static void LoginInvalidEmail() {
        //Login Not Existing Email:
        //Precondition: Chrome browser should be opened DONE
           // declare driver
        //Step1. Open koel login page DONE
           // tell driver to load koel page
        //Step2. Enter Not Existing email
           // find email field
           // click into email field
           // enter invalid email inside email field
        //Step3. Enter Correct password
           // find password field
           // click into password field
           // enter anything
        //Step4. Click Login button
           // find the login button
           // click the login button
        //Expected result: User should stay on login page
           // assert the present of email field

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        //Step2. Enter Not Existing email
        // find email field
        // click into email field
        // enter invalid email inside email field
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));

        emailField.click();
        emailField.sendKeys("cucaracha@class.com");

        //Step3. Enter Correct password
        // find password field
        // click into password field
        // enter anything
        passwordField.click();
        passwordField.sendKeys("ayCaramba");

        //Step4. Click Login button
        // find the login button
        // click the login button
       loginButton.click();

        //Expected result: User should stay on login page
        // assert the present of email field
        Assert.assertTrue(emailField.isDisplayed());
        driver.quit();
    }

    @Test
    public static void LoginValidEmailPasswordTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement loginField = driver.findElement(By.cssSelector("[type='submit'"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));
        WebElement avatar = driver.findElement(By.className("avatar"));



        emailField.click();
        emailField.sendKeys("demo@class.com");
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        loginField.click();
        Assert.assertTrue(avatar.isDisplayed());

        driver.quit();
    }
}
