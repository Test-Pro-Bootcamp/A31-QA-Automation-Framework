import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
   // @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
   @Test
    public static void loginEmptyEmailPasswordTest () {
       LoginPage loginPage = new LoginPage(driver);

       loginPage.submitBtn();

       Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest () throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
          loginpage.provideEmail("karkisuman0330@gmail.com");
          loginpage.providePassword("te$t$tudent");
          loginpage.submitBtn();

       /* provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();*/

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void loginInvalidEmailValidPasswordTest () {
       LoginPage loginpage = new LoginPage(driver);
        loginpage.provideEmail("invalid@class.com");
       loginpage.providePassword("te$t$tudent");
       loginpage.submitBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }



}
