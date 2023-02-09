import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(enabled = false, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("simplyd2d@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(enabled = true, priority = 1, description = "Login with Valid Email and Password")
    public void loginValidEmailValidPasswordTest(String email, String password) {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent")
                .clickSubmitBtn();

    }

    @Test(enabled = true, priority = 2, description = "Login with Invalid Email and Valid Password Test")
    public void LoginInvalidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("simplyd2d@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
    }

}

