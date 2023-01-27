import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class Homework25 extends BaseTest{
    @Test(enabled= true, priority = 1, description="Login Test")
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.logIn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(enabled= true, priority = 2, description="Play Song Test")
    public void playSongTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());
        loginPage.logIn();
        songsPage.clickAllSongsTab();
        songsPage.selectAndPlaySong();
        songsPage.isSongPlaying();
    }

}

