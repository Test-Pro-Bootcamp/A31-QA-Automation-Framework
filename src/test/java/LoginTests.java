import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () {

        //Precondition: Chrome Browser should open up
        //Step 1: Open the Koel login page
        //Step 2: Enter Existing USERNAME
        //Step 3: Enter Correct PASSWORD
        //Step 4: Click login button
        //Expected result: User should be directed to the home page

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();




    }
}
