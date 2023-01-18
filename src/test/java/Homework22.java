import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginpage.logIn();
        homePage.allSongs();
        allSongsPage.songName();
        allSongsPage.playNextButton();
        allSongsPage.playButton();

        Assert.assertTrue(allSongsPage.soundBars());
    }
}

