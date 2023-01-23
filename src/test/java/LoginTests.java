import Homework23.HomePage23;
import Homework23.LoginPage23;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    //@Test(enabled = false, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    //public static void loginEmptyEmailPasswordTest (String email, String password) {
      //  LoginPage loginPage = new LoginPage(driver);

        //login(email, password);
        //Assert.assertEquals(driver.getCurrentUrl(), url);
    //}

    //Page Object Model example
    @Test(enabled = true, priority = 1, description = "Login with Valid Email and Password Test")
    public void LoginValidEmailPasswordTest () {

        LoginPage23 loginPage23 = new LoginPage23(driver);
        HomePage23 homePage23 = new HomePage23(driver);

        loginPage23.provideEmail("demo@class.com").providePassword("te$t$tudent").clickSubmitBtn();
        Assert.assertTrue(homePage23.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "Login with Invalid Email and Valid Password Test")
    public static void loginInvalidEmailValidPasswordTest () {

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }



}
