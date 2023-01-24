import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    @Test(enabled = false, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest (String email, String password) {
        LoginPage loginPage = new LoginPage(LoginTests.driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(LoginTests.driver.getCurrentUrl(), url);
    }

    //Page Object Model example
    @Test(enabled = true, priority = 1, description = "Login with Valid Email and Password Test")
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(LoginTests.driver);
        HomePage homePage = new HomePage(LoginTests.driver);

        loginPage.provideEmail("pooja.bankar@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "Login with Invalid Email and Valid Password Test")
    public void loginInvalidEmailValidPasswordTest () {
        LoginPage loginPage = new LoginPage(LoginTests.driver);

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(LoginTests.driver.getCurrentUrl(), url);

    }

}
