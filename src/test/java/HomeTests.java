import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class HomeTests extends BaseTest{
//hovering over play button
    @Test(enabled = true,groups = {"Regression"},priority = 0, description = "Search a song test")
    public void hoverOverPlayBtnTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        loginPage.logIn();
        songsPage.chooseAllSongsList();
        homePage.hoverPlay();
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());

    }

    @Test(enabled = true, priority = 1,groups = {"Regression"},description = "Search a song test")
    public void searchSongTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
            loginPage.logIn();
            homePage.searchSong("Take my Hand (ID 1696)");
            homePage.viewAllSearchResults();
        }
}
