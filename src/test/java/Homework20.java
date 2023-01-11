import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Sample Playlist");
        addSongToThePlaylist("Pluto", "Sample Playlist");

        Assert.assertTrue(songIsAddedMsg());
    }

    @Test
    public void playSong() {
        login("hand923@gmail.com", "te$t$tudent");
        playSong("Dark Days");

        Assert.assertTrue(validateSongIsPlaying());
    }

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Empty Playlist");
        deletePlaylist();

        Assert.assertTrue(isDeleted());
    }
}
