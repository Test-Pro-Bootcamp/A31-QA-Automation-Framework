import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public static void loginEmptyEmailPasswordTest () {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
