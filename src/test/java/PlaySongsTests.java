import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlaySongsTests extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void playSongFromAllSongs() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.clickAllSongs();

        allSongsPage.selectFirstSong()
                .playSelectedSong();
        Assert.assertTrue(allSongsPage.isPlaying().isDisplayed());
    }
}