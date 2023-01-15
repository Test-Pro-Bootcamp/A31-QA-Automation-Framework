import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomPlaylistPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CustomPlaylistPage customPlaylistPage = new CustomPlaylistPage(driver);

        loginPage.login("hand923@gmail.com", "te$t$tudent");

        homePage.createdCustomPlaylist("Empty Playlist");
        Assert.assertTrue(homePage.getSuccessMsg());

        homePage.clickPlaylist();

        customPlaylistPage.deleteEmptyPlaylist();
        Assert.assertTrue(customPlaylistPage.isDeleted());
    }
}
