import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "IncorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest (String email, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailValidPasswordTest (){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        homePage.getUserAvatar();

    }

    @Test
    public void loginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
