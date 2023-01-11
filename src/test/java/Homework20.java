import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Sample Playlist");
        addSongToThePlaylist("Pluto", "Sample Playlist");

        Assert.assertTrue(songIsAddedMsg());
    }

    @Test
    public void playSong() {
        login("hand923@gmail.com", "te$t$tudent");
        playSelectedSong("Dark Days");

        Assert.assertTrue(validateSongIsPlaying());
    }

    @Test
    public void deletePlaylist() {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Empty Playlist");
        deleteEmptyPlaylist("Empty Playlist");

        Assert.assertTrue(isDeleted());
    }
}
