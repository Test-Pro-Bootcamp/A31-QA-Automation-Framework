import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist() {

        String newPlaylistName = "Edited Playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.doubleClickFirstPlaylist()
                .renamePlaylist(newPlaylistName);
        Assert.assertTrue(homePage.getSuccessMsg().isDisplayed());
    }
}
