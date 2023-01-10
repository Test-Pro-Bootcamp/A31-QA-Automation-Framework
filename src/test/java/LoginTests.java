import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {


    @Test (enabled = true, priority = 0, description = "LoginEmptyPasswordTest")
    public static void LoginEmptyPasswordTest() throws InterruptedException {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(url));
    }

        @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
        public static void LoginValidEmailValidPasswordTest () throws InterruptedException {

            navigateToPage();
            provideEmail("demo@class.io");
            providePassword("te$t$tudent");
            clickSubmit();
            Thread.sleep(3000);
            WebElement avatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
            Assert.assertTrue(avatarIcon.isDisplayed());


        }
    }