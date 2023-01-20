import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.AllSongsPage;

public class Homework22 extends BaseTest{
    @Test
    public void playSong(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginpage.logIn();
        homepage.allSongs();
        allSongsPage.songName();
        allSongsPage.playNextButton();
        allSongsPage.playButton();

        Assert.assertTrue(allSongsPage.soundBars());
    }
}
