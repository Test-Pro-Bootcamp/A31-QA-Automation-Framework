import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void createNewPlaylist()   {
        String playlistName="Test Playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.clickNewPlaylistIcon();
        homePage.clickNewPlaylistOption();
        homePage.enterNewPlaylistName(playlistName);
    }

    @Test
    public void renamePlaylist(){
        String playlistName = "Edited Playlist";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.doubleClickFirstUserPlaylist();
        homePage.enterNewPlaylistName(playlistName);
        Assert.assertTrue(homePage.getPopUpNotificationText().contains("Updated playlist"));

    }

    @Test
    public void addASongToPlaylist()   {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());


        loginPage.logIn();
        homePage.clickAllSongs();
        allSongsPage.rightClickChosenSong(2);
        allSongsPage.clickAddToOption();
        allSongsPage.choosePlaylistToAddTo("Playlist to Add a Song");
        Assert.assertTrue(homePage.getPopUpNotificationText().contains("Added 1 song into"));

    }
    @Test
    public void deletePlaylist()   {
        String playlistName = "test playlist";


        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage =new HomePage(getDriver());

        loginPage.logIn();
        homePage.contextClickFirstUserPlaylist();
        homePage.chooseDeletePlaylistOption();
        Assert.assertTrue(homePage.getPopUpNotificationText().contains("Deleted playlist"));
    }
}




