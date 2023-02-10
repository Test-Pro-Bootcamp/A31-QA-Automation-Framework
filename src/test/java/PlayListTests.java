import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;

public class PlayListTests extends BaseTest{

    //Create Playlist
    @Test(enabled = true,priority = 0,groups = {"Regression"},description = "Creating New Playlist Test")
    public void createNewPlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PlayListPage playlistPage = new PlayListPage(getDriver());
        loginPage.logIn();
        homePage.createPlaylist("Summer Songs");

        Assert.assertTrue(playlistPage.isPlaylistCreatedMessageDisplayed());
    }

    //Rename Playlist
    @Test(enabled = true,priority = 1,groups = {"Regression"},description = "Rename Playlist Name Test")
    public void renamePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        homePage.createPlaylist("actualName");
        homePage.choosePlaylist("actualName");
        homePage.doubleClickChoosePlaylist("actualName");
        homePage.enterPlaylistName("NewName");
        Assert.assertTrue((homePage.playlistRenamedMsgisDisplayed()));
    }

    //delete Playlist
    @Test(enabled = true,priority = 2,groups = {"Regression"},description ="Delete playlist test " )
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.selectPlaylistToDelete("NewName");
        homePage.deletePlaylist();
        Assert.assertTrue(homePage.isplaylistDeleted());
    }

}
