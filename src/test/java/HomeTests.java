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

            loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();
            homePage.createPlaylist("Homework OMG");
            allSongsPage.addSongToThePlaylist("Pluto", "Homework OMG");
            allSongsPage.navigateToPlaylist("Homework OMG");

            Assert.assertTrue(allSongsPage.confirmSongIsAdded("Pluto"));
        }

        @Test(enabled = true, priority = 1, groups = {"Smoke", "Regression"}, description = "Delete a playlist")
        public void deletePlaylist() {

            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();
            homePage.createPlaylist("Homework Crazy");
            homePage.selectDesiredPlaylist("Homework Crazy");
            homePage.deleteDesiredPlaylist();
            Assert.assertTrue(homePage.deletionMsg());
        }

        @Test(enabled = true, priority = 2, groups = {"Smoke", "Regression"}, description = "Rename a playlist")
        public void renamePlaylist() {

            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();
            homePage.createPlaylist("Homework");
            homePage.choosePlaylist("Homework");
            homePage.doubleClickChoosePlaylist("Homework");
            homePage.enterPlaylistName("Homework Test");
            Assert.assertTrue((homePage.getSuccessMsg()));
        }

        @Test(enabled = true, priority = 0, groups = {"Regression"}, description = "Search a song")
        public void searchSong() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();
            homePage.searchSong("Pluto");
            homePage.viewAllSearchResults();
        }

        @Test(enabled = true, priority = 0, groups = {"Regression"}, description = "Hover over play button")
        public void hoverOverPlayButton() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            AllSongsPage allSongsPage = new AllSongsPage(getDriver());

            loginPage.provideEmail("simplyd2d@gmail.com").providePassword("te$t$tudent").clickSubmit();
            allSongsPage.allSongs();
            homePage.hoverPlay();
            Assert.assertTrue(homePage.hoverPlay().isDisplayed());
        }
    }

