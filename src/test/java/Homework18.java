import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.provideEmail("hand923@gmail.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitButton();

        homePage.clickAllSongs();

        allSongsPage.selectFirstSong()
                    .playSelectedSong();
        Assert.assertTrue(allSongsPage.isPlaying().isDisplayed());
    }
}
