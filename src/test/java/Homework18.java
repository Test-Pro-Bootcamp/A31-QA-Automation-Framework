import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        login("hand923@gmail.com", "te$t$tudent");
        playSong("Dark Days");

        Assert.assertTrue(validateSongIsPlaying());
    }
}
