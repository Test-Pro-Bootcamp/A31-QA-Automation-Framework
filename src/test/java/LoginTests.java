import org.openqa.selenium.By;
Homework17
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
 main
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

Homework17

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
=======

    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public static void LoginEmptyEmailPasswordTest () {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void LoginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void LoginInvalidEmailValidPasswordTest () {

        navigateToPage();

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

 main
    }


}
