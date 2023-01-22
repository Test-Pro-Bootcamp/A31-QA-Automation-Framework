
import Homework22.HomePage22;
import Homework22.LoginPage22;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

  //  @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    //@Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
  // public static void loginEmptyEmailPasswordTest (String email, String password) {

  //      login(email, password);
  //     Assert.assertEquals(driver.getCurrentUrl(), url);
  //  }

    //Page Object Model example
    @Test
    public void loginValidEmailPasswordTest  () throws InterruptedException {

        HomePage22 homepage22 = new HomePage22 (driver);
        LoginPage22 loginPage22 = new LoginPage22(driver);


        loginPage22.provideEmail("demo@class.com");
        loginPage22.providePassword("te$t$tudent");
        loginPage22.clickSubmitBtn();
        Thread.sleep(5000);
        homepage22.doubleClickFirstPlaylist();
        homepage22.enterPlaylistName("Test Pro Playlist");
        homepage22.doesPlaylistExist();

        WebElement userBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(userBadge.isDisplayed());
    }

 //   @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
 //   public static void loginInvalidEmailValidPasswordTest () {

        //provideEmail("invalid@class.com");
        //providePassword("te$t$tudent");
        //clickSubmit();

 //       Assert.assertEquals(driver.getCurrentUrl(), url);

   // }



}
