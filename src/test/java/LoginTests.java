import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    @Test
    public void LoginEmptyEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("amandaag39@gmail.com").providePassword("te$t$tudent").clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
