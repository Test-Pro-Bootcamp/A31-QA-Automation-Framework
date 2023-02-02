import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18mc extends BaseTest {

    @Test(priority = 1, description = "Play a song and assert a song is playing")
    public void playSong() {
        login("demo@class.com", "te$t$tudent");
        playSong();

        Assert.assertTrue(isDisplayedPlayingSong());
    }
}
// I'm not sure why it's not working, maybe due to too much code? But I can't figure out what to remove