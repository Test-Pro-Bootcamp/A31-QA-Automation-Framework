import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public static void LoginEmptyEmailPasswordTest () {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void LoginValidEmailValidPasswordTest () throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void LoginInvalidEmailValidPasswordTest () throws InterruptedException {
        login("invalidemail@gmail.com", "te$t$tudent");

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}
