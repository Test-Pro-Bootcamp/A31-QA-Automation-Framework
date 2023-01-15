import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("hand923@gmail.com", "te$t$tudent");

        homePage.createdCustomPlaylist("Original Playlist");
        homePage.doubleClickPlaylist();
        homePage.renamePlaylist("Edited Playlist");
        Assert.assertTrue(homePage.getSuccessMsg());
    }
}
