import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void LoginPageValidEmailPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.addPlaylist();
        homePage.clickNewPlaylist();
        homePage.namePlaylist();
        homePage.doubleClickToPlaylist();
        homePage.newPlaylistName();
        }