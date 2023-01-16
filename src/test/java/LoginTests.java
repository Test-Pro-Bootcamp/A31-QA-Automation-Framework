import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginValidEmailPasswordTest () {
        LoginPage login = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        login.login();
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
    }
}