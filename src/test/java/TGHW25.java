import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TGHW25 extends BaseTest {
    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest(String email, String password) {
        login(email, password);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void loginValidEmailValidPasswordTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        homePage.getUserAvatar();

    }
}
