import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageTest;
import pages.LoginPageTest;

public class Homework21Test extends BaseTest {



    @Test
    public void renamePlaylist() {
        String playlistName = "Jarrod Playlist";
        LoginPageTest loginPage = new LoginPageTest(driver);
        HomePageTest homePage = new HomePageTest(driver);
        loginPage.logIn();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.verifyPlaylistExists(playlistName));
    }
}


