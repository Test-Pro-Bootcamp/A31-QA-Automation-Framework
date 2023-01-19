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

        String playlistName = "Empty Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CustomPlaylistPage customPlaylistPage = new CustomPlaylistPage(driver);

        loginPage.provideEmail("hand923@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();

        homePage.createCustomPlaylist(playlistName)
                .clickFirstPlaylist();

        customPlaylistPage.deleteEmptyPlaylist();
        Assert.assertTrue(customPlaylistPage.getSuccessMsg().isDisplayed());
    }
}
