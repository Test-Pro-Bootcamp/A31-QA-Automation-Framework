import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest {
    @Test(enabled = true, priority = 0, groups = {"Smoke", "Regression"}, description = "Add a song to the playlist")
    public void addSongToPlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        homePage.createPlaylist("HW17");
        allSongsPage.addSongToThePlaylist("Frantic", "HW17");
        allSongsPage.navigateToPlaylist("HW17");

        Assert.assertTrue(allSongsPage.confirmSongIsAdded("Frantic"));
    }

    @Test(enabled = true, priority = 1, groups = {"Smoke", "Regression"}, description = "Delete a playlist")
    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        homePage.createPlaylist("HW19");
        homePage.selectDesiredPlaylist("HW19");
        homePage.deleteDesiredPlaylist();
        Assert.assertTrue(homePage.deletionMsg());
    }

    @Test(enabled = true, priority = 2, groups = {"Smoke", "Regression"}, description = "Rename a playlist")
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        homePage.createPlaylist("HW");
        homePage.choosePlaylist("HW");
        homePage.doubleClickChoosePlaylist("HW");
        homePage.enterPlaylistName("HW21");
        Assert.assertTrue((homePage.getSuccessMsg()));
    }

    @Test(enabled = true, groups = {"Regression"}, description = "Search a song")
    public void searchSong() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("test123@test.com").providePassword("te$t$tudent").clickSubmit();
        homePage.searchSong("Ketsa");
        homePage.viewAllSearchResults();
    }
}
