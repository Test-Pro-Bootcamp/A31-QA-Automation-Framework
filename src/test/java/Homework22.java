import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() throws InterruptedException {

        String playlistName = ("Test Pro Rockstars");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        //Thread.sleep(1000);
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        //Thread.sleep(1000);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));

    }

}
