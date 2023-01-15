import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login("hand923@gmail.com", "te$t$tudent");

        homePage.clickAllSongs();

        allSongsPage.playSelectedSong();
        Assert.assertTrue(allSongsPage.isPlaying());
    }
}
