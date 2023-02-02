import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginPageValidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
//        homePage.addPlaylist();
//        homePage.clickNewPlaylist();
//        homePage.namePlaylist();
//        homePage.doubleClickToPlaylist();
//        homePage.newPlaylistName();
    }

    @Test
    public void loginEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("test@mail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
    }



}