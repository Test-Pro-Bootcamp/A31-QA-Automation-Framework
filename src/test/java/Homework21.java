import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        login();
        addPlaylist();
        newPlaylist();
        namePlaylist();
        doubleClickToPlaylist();
        choosePlaylist();
        newPlaylistName();
    }
}
