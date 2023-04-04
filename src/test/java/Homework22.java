import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() {

        String playlistName = ("Test Pro Rockstars");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();

        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);

        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));

    }

}
