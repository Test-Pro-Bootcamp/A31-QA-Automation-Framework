

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework22 extends BaseTest {


    @Test
    public void refactorRenamePlayList()  {
        String playlistName = "Summer Songs";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName();
        Assert.assertTrue(homePage.doesPlaylistExist());
    }

}
