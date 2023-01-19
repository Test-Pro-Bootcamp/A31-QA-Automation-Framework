import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {

    @Test
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


}
