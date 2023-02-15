import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.rightClickPlaylist();
        songPage.deletePlaylist();
        songPage.verifyPlaylistIsDeleted();

        closeBrowser();
    }

}
