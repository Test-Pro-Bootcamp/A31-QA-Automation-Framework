import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test (enabled = true, priority = 1, description = "LoginEmptyEmailPasswordTest")
    public static void LoginEmptyEmailPasswordTest () {

        navigateToPage();
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public static void loginValidEmailValidPasswordTest (){

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public static void loginInvalidEmailValidPasswordTest() {

        navigateToPage();

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
