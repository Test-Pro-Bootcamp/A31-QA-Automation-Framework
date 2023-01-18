
import Homework22.HomePage22;
import Homework22.LoginPage22;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    //@Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
   public static void loginEmptyEmailPasswordTest (String email, String password) {

        login(email, password);
       Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    //Page Object Model example
    @Test(enabled = true, priority = 1, description = "loginValidEmailPasswordTest")
    public static void loginValidEmailPasswordTest () {

        HomePage22 HomePage22 = new HomePage22(driver);
        LoginPage22 LoginPage22 = new LoginPage22(driver);

        LoginPage22.login();
        HomePage22.getUserAvatar().isDisplayed();
        HomePage22.doubleClickFirstPlaylist();
        HomePage22.enterPlaylistName("Test Pro Playlist");
        HomePage22.doesPlaylistExist("Test Pro Playlist");
      //  LoginPage22.provideEmail("demo@class.com");
      //  LoginPage22.providePassword("te$t$tudent");
      //  LoginPage22.clickSubmitBtn();
    }

 //   @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
 //   public static void loginInvalidEmailValidPasswordTest () {

        //provideEmail("invalid@class.com");
        //providePassword("te$t$tudent");
        //clickSubmit();

 //       Assert.assertEquals(driver.getCurrentUrl(), url);

   // }



}
