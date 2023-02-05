import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class playSongTest extends BaseTest {
    @Test
    public void playSongTest () {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.provideEmail("amandaag39@gmail.com").providePassword("te$t$tudent").clickSubmitBtn();

        //navigate to 'All Songs'
        homePage.navigateToAllSongsPage();

        //double-click a song
        allSongsPage.doubleClickSong();

        //verify song is playing
        Assert.assertTrue(homePage.soundBarsShownMethod().isDisplayed());
    }
}
