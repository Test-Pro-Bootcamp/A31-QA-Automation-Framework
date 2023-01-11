import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        openLogUrl();
        login();
        createPlaylist();
        addSongToThePlaylist();
        validateSongIsAdded();
    }


}
