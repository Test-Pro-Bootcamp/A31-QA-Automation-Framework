import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    public static String url = "https://bbb.testpro.io/";

    @Test(enabled = true, priority = 0, description = "loginEmptyEmailPasswordTest")
    public static void loginEmptyEmailPasswordTest() throws InterruptedException {

        //****Each one of these methods has been created for a shortcut to include it's designated step
        //****The actual code for each method can be found on the BaseTest

        navigateToPage();
        provideEmail("");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "loginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest() throws InterruptedException {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement clickAvatarIcon = driver.findElement(By.cssSelector("ing.avatar"));
        Assert.assertTrue(clickAvatarIcon.isDisplayed());
    }

    @Test(enabled = true, priority = 2, description = "loginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest() throws InterruptedException {

        navigateToPage();
        provideEmail("johndoe@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);


    }
}