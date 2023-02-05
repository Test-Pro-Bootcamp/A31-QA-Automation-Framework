import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class addSongToPlaylistTest extends BaseTest {

    @Test
    public void addSongToPlaylistTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        PlaylistPage playlistPage = new PlaylistPage(getDriver());

        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //navigate to 'All Songs'
        homePage.navigateToAllSongsPage();

        //right-click on song
        allSongsPage.rightClickSong();

        //click on add to
        homePage.clickAddTooButton();

        //click on XYZ Playlist in dropdown
        homePage.clickXYZInDropdown();

        //navigate to XYZ Playlist
        homePage.selectXYZPlaylist();

        //check for song in playlist
        Assert.assertTrue(playlistPage.confirmXYZPlaylist().isDisplayed());

    }

}
