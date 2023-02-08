import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() {
        LoginPage loginPage = new LoginPage(driver);
        AllSongPage allSongPage = new AllSongPage(driver);

        loginPage.logIn();
        allSongPage.playSong("Reactor");
        allSongPage.songIsPlaying();
    }


}
