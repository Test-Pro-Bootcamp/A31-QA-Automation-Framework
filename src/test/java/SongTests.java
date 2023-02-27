import Pages.LoginPage;
import Pages.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class SongTests extends BaseTest{
    @Test
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongPage songPage = new SongPage(getDriver());

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.rightClickPlaylist();
        songPage.deletePlaylist();
        songPage.verifyPlaylistIsDeleted();
    }
    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");

        songPage.addPlaylistButton();
        songPage.newPlaylistButton();
        songPage.selectPlaylistField();
        songPage.selectHomeButton();
        songPage.rightClickSong();
        songPage.addToPlaylist();
        songPage.clickPlaylist();
    }

    @Test
    public void playaSongTest() {
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.playSong();
        songPage.isSongPlaying();

    }

    @Test
    public void renamePlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongPage songPage = new SongPage(getDriver());

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.rightClickPlaylist();

        songPage.clickEdit();
        songPage.editField();
    }

}
