
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageTest;
import pages.LoginPageTest;


public class LoginTests extends BaseTest {


    @Test
    public void loginValidEMailPasswordTest() {
            LoginPageTest loginPage = new LoginPageTest(driver);
            HomePageTest homePage = new HomePageTest(driver);
            loginPage.logIn();
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }
    }

