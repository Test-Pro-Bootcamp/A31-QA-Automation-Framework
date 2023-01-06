import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();

        provideEmail("test123@test.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
