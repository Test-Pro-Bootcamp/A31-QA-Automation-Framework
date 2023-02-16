import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongTests extends BaseTest{

    @Test
    public void playASongTest() {
        AllSongPage allSongPage = new AllSongPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        allSongPage.chooseAllSongsList();
        allSongPage.selectFirstSong();
        allSongPage.doubleClickFirstSong();
        Assert.assertTrue(allSongPage.songIsPlaying().isDisplayed());
    }
    @Test
    public void createPlaylist(){
        AllSongPage allSongPage = new AllSongPage(driver);
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        allSongPage.buttonPlus();
        allSongPage.playListBtn();
        homePage.enterPlaylistName("AllPlaylist");
        homePage.doesPlaylistExist("AllPlaylist");

    }
}
