import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.CustomPlaylistPage;
import pages.HomePage;
import pages.LoginPage;

public class CustomPlaylistTests extends BaseTest{

    @Test (groups = {"smoke", "regression"})
    public void addSongToCustomPlaylist() {

        String playlistName = "Sample Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.createCustomPlaylist(playlistName)
                .clickAllSongs();

        allSongsPage.selectFirstSong()
                .addSongToPlaylist();
        Assert.assertTrue(allSongsPage.getSuccessMsg().isDisplayed());
    }

    @Test (groups = {"smoke", "regression"})
    public void renamePlaylistWithPlaylistName() {

        String newPlaylistName = "Edited Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.doubleClickFirstPlaylist()
                .renamePlaylist(newPlaylistName);
        Assert.assertTrue(homePage.getSuccessMsg().isDisplayed());
    }

    @Test (groups = {"smoke", "regression"})
    public void deletePlaylist() {

        String playlistName = "Empty Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CustomPlaylistPage customPlaylistPage = new CustomPlaylistPage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.createCustomPlaylist(playlistName)
                .clickFirstPlaylist();

        customPlaylistPage.deleteEmptyPlaylist();
        Assert.assertTrue(customPlaylistPage.getSuccessMsg().isDisplayed());
    }
}
