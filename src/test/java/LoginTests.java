import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    static String url="https://bbb.testpro.io/";
    @Test
    public static void loginEmptyEmailPasswordTest () {

        navigateToPage();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
