import org.testng.annotations.Test;
import pages.AllSongPage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() {
        AllSongPage allSongPage = new AllSongPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        allSongPage.playSong();
        allSongPage.isSongPlaying();
    }
}
