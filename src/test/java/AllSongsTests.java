import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTests extends BaseTest {
    @Test(enabled = true, priority = 0, groups = {"Smoke", "Regression"}, description = "Play a song")
    public void playSong() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        allSongsPage.allSongs();
        allSongsPage.playSelectedSong("Dark Days");
        Assert.assertTrue(allSongsPage.validateSongIsPlaying());
    }
}
