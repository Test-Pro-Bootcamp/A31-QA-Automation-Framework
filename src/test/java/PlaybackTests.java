import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

public class PlaybackTests extends BaseTest{

    @Test
    public void playASongFromHomepage() {
        LoginPage lp = new LoginPage(getDriver());
        lp.logIn();

        HomePage hp = new HomePage(getDriver());
        hp.playSong();

        Assert.assertTrue(hp.songIsPlaying());
    }

    @Test
    public void playASongFromSongsPage(){
        LoginPage lp = new LoginPage(getDriver());
        lp.logIn();

        HomePage hp = new HomePage(getDriver());
        hp.clickAllSongs();

        SongsPage sp = new SongsPage(getDriver());
        sp.playRandomSong();

        Assert.assertTrue(hp.soundbar.isDisplayed());
    }

}
