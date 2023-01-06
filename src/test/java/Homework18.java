import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        enterEmail("ryan.carter@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        navigateToAllSongs();
        playDesiredSong();

        Assert.assertTrue(validateSongIsPlaying());
        Thread.sleep(1500);
    }
}