import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



public class LoginTests extends BaseTest {

        @Test
        public static void loginValidEmailPasswordTest() {

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("simplyd2d@gmail.com");
            loginPage.providePassword("te$t$tudent");
            loginPage.clickSubmit();
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());


        }
}