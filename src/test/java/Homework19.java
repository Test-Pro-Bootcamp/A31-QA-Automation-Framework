import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework19 extends BaseTest {

    @Test
    public static void deletePlaylist() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        //Enter tester username
        loginPage.provideEmail("amandaag39@gmail.com");

        //Enter password
        loginPage.providePassword("te$t$tudent");

        //Click login button
        loginPage.clickSubmitBtn();

        //click add button
        homePage.clickAddButton();

        //select New Playlist from dropdown
        homePage.selectNewPlaylistFromDropdown();

        //create XYZ Playlist
        homePage.createXYZPlaylist();

        //confirm playlist creation
        Assert.assertTrue(homePage.confirmXYZPlaylist().isDisplayed());

        //select XYZPlaylist
        homePage.selectXYZPlaylist();

        //click deletePlaylistButton
        playlistPage.deletePlaylist();

        //validate playlist deletion
        Assert.assertTrue(playlistPage.getDeletePlaylistButton().isDisplayed());

    }
}

