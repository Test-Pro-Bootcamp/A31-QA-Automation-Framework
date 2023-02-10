import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest{

    @Test(enabled = true,priority = 0,groups = {"Regression"},description = "Playing song from all songs directory")
    public void playSongTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        homePage.clickAllSongsTab();
        songsPage.selectAndPlaySong();
        Assert.assertTrue(songsPage.isSongPlaying());
    }

    @Test(enabled = true,priority = 1,groups = {"Regression"},description = "Adding Song to Existing Playlist")
    public void addSongToPlayListTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        homePage.clickAllSongsTab();
        songsPage.selectFirstSongFromAllSongs();
        songsPage.addToButton();
        songsPage.selectAllReadyCreatedPlayList();
        Assert.assertTrue(songsPage.isSongAddedMessageDisplayed());

    }
}