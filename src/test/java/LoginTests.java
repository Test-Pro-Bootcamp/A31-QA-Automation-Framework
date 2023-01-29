
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest {


    @Test
    public void loginValidEMailPasswordTest() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);
            loginPage.logIn();
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }
    }

