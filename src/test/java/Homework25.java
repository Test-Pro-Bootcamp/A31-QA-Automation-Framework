import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework25 extends BaseTest {
    @Test
    public void deletePlaylist ()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        homePage.enterPlayList();
        homePage.clickDelete();

            }
}

