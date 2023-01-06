import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("test123@test.com", "te$t$tudent");
        allSongs();
        playSelectedSong();
        validateSongIsPlaying();
    }
}
