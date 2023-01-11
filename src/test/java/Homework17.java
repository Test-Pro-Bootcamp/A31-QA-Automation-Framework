import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Sample Playlist");
        addSongToThePlaylist("Pluto", "Sample Playlist");

        Assert.assertTrue(songIsAddedMsg());
    }


}
