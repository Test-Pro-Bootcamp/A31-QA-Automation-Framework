import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToCustomPlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login("hand923@gmail.com", "te$t$tudent");

        homePage.createdCustomPlaylist("Sample Playlist");
        Assert.assertTrue(homePage.getSuccessMsg());

        homePage.clickAllSongs();

        allSongsPage.addSongToPlaylist();
        Assert.assertTrue(allSongsPage.getSuccessMsg());
    }


}
