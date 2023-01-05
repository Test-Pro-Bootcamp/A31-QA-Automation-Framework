import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        enterEmail("hand923@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        navigateToAllSongs();
        playDesiredSong();

        Assert.assertTrue(validateSongIsPlaying());
        Thread.sleep(1500);
    }
}
