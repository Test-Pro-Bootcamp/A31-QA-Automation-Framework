import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23_Serge extends BaseTest {
    @Test
    public void renamePlaylist()   {
        String playlistName = "Edited Playlist 5";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmitBtn();

        homePage.doubleClickFirstPlaylist()
                .enterPlaylistName(playlistName);

        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}


