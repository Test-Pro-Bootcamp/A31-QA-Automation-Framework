import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException{
        //test: login with empty email and password field
        //precondition: chrome browser is opened
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //step 1: navigate to koel login page
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(1000);

        //step 2: click login button //find login button //click it
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        loginButton.click();

        //confirm user is still on login page
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Thread.sleep(1000);

        driver.quit();
    }

    @Test
    public static void LoginInvalidEmail() throws InterruptedException{
        //test: login with invalid/non-existent email
        //precondition: chrome browser should be opened
        //step 1: navigate to koel login page
        //step 2: enter invalid email
        //step 3: enter correct password
        //step 4: click login button
        //expected result: user should stay on login page

        //init webdriver, set longer wait time to help test not auto fail
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String loginPageUrl = "https://bbb.testpro.io/";

        //step 1: navigate to koel login page
        driver.get(loginPageUrl);
        Thread.sleep(1000);

        //step 2: enter invalid email //find email field //click it //type in bad email
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys("bademailgenerator69@gmail.com");

        //step 3: enter correct password //find pw field //click it //type in correct pw
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        //step 4: click login button //find login button //click it
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        loginButton.click();
        Thread.sleep(1000);

        //confirm user is not logged in //still on login page
        Assert.assertEquals(driver.getCurrentUrl(), loginPageUrl);

        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public static void LoginValidEmailPasswordTest() throws InterruptedException{
        //test: login with valid credentials
        //precondition: Chrome browser should be opened
        //step 1: open koel login page
        //step 2: enter existing username
        //step 3: enter correct password
        //step 4: click login button
        //expected result: user should be directed to koel home page

        //init new webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //step 1: open koel login page
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(1000);

        //step 2: enter existing username //find email field //click email field //type text into email field
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        //WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("jimmypvu@gmail.com");
        Thread.sleep(1000);

        //step 3: enter correct password //find password field //click password field //type text into password field
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        //Thread.sleep(2000); is a try/catch block
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        //step 4: click login button //find login button //click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        loginButton.click();
        Thread.sleep(1000);

        //confirm result: user should be taken to koel home page //playlists should visible //logout button visible //avatar etc
        String koelHomePage = "https://bbb.testpro.io/#!/home";
        Assert.assertEquals(driver.getCurrentUrl(), koelHomePage);
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
        WebElement logoutButton = driver.findElement(By.cssSelector("[data-testid='btn-logout']"));
        Assert.assertTrue(logoutButton.isDisplayed());
        WebElement playlists = driver.findElement(By.id("playlists"));
        Assert.assertTrue(playlists.isDisplayed());
        Thread.sleep(1000);

        driver.quit();
    }


}
