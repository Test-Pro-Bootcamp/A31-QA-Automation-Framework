import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class HomeWork23 extends BaseTest{
//    @Test
//    public void loginValidEmailPasswordTest() {
//
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//        loginPage.logIn();
//    }

//    @Test
//    public void playSongTest(){
//        LoginPage loginPage = new LoginPage(driver);
//        SongsPage songsPage = new SongsPage(driver);
//        HomePage homePage = new HomePage(driver);
//        loginPage.logIn();
//        homePage.clickAllSongsTab();
//        songsPage.selectAndPlaySong();
//    }

    @Test
    public void addSongToPlayListTest(){
        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.logIn();
        homePage.clickAllSongsTab();
        songsPage.addSongToFavouriteList();
//        songsPage.selectFirstSongFromAllSongs();
//        songsPage.addToButton();
//        songsPage.selectAllReadyCreatedPlayList();
    }
}
////td//button[@title='Like Pluto by Makaih Beats']//i[@class='fa fa-heart-o']