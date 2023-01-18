
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class HomeWork22 extends BaseTest{
    @Test
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void playSongTest(){
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);
        loginPage.logIn();
        songsPage.clickAllSongsTab();
        songsPage.selectAndPlaySong();
        songsPage.isSongPlaying();
    }

    @Test
    public void addSongToPlayListTest(){
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);
        loginPage.logIn();
        songsPage.clickAllSongsTab();
        songsPage.selectFirstSongFromAllSongs();
        songsPage.addToButton();
        songsPage.selectAllReadyCreatedPlayList();
        songsPage.isSongAddedMessageDisplayed();
    }


}


