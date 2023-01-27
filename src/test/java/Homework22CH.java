import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TestProPlaylistPage;

public class Homework22CH extends BaseTest{



    @Test
    public void refactorAllSongs() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.logIn();
        allSongsPage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlay();
        Assert.assertTrue(songIsPlaying());
        Thread.sleep(3000);
  }
    @Test
    public void refactorPlaylist() throws InterruptedException{
        String playListName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        TestProPlaylistPage testProPlaylistPage = new TestProPlaylistPage(driver);

        loginPage.logIn();
        homePage.doubleClickChoosePlaylist();
        homePage.enterPlaylistName(playListName);
        Assert.assertTrue(homePage.doesPlaylistExist());
        Thread.sleep(3000);
    }
}
