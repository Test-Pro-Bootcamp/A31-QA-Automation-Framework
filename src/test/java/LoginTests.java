import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @BeforeMethod
    public static void launchBrowser() {
        Homework17.driver = new ChromeDriver();
        Homework17.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeBrowser () {
        Homework17.driver.quit();
    }

    public static void clickSubmit() {
        //find the submit button
        WebElement submitButton = Homework17.driver.findElement(By.cssSelector("[type='submit']"));
        // click into submit button
        submitButton.click();
    }

    public static void providePassword() {
        //find the password field
        WebElement passwordField = Homework17.driver.findElement(By.cssSelector("[type='password']"));
        // click into password field
        passwordField.click();
        // enter valid password
        passwordField.sendKeys("te$t$tudent");
    }

    public static void provideEmail() {
        WebElement emailField = Homework17.driver.findElement(By.cssSelector("[type='email']"));
        // click into email field
        emailField.click();
        // enter valid email inside the email field
        emailField.sendKeys("sandra.geche@gmail.com");
    }
}
