import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() {
        AllSongPage allSongPage = new AllSongPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        allSongPage.playSong();
        allSongPage.isSongPlaying();
    }
}
