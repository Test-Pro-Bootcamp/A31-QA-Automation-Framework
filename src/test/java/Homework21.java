import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist() {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Original Playlist");

    }
}
