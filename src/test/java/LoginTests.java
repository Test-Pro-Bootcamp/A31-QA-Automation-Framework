import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());

        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPasswordTest () {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
}