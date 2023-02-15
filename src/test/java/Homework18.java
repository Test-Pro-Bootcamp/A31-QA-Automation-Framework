import Pages.LoginPage;
import Pages.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playaSongTest() {
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        songPage.playSong();
        songPage.isSongPlaying();

        closeBrowser();
    }

}
