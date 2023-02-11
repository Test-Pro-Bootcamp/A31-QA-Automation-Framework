import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
//    @Test (enabled = true, priority = 1, description = "LoginEmptyEmailPasswordTest")
    @Test(dataProvider = "IncorrectLoginProvider", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest (String email, String password) {

        login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public static void loginValidEmailValidPasswordTest (){

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public static void loginInvalidEmailValidPasswordTest() {

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
