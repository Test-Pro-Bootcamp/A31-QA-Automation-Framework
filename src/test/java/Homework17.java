import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist();
        addSongToThePlaylist();
        validateSongIsAdded();
    }


}
