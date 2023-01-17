import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public static void renamePlaylist() {
        login();
        addPlaylist();
        newPlaylist();
        namePlaylist();
        doubleClickToPlaylist();
        choosePlaylist();
        newPlaylistName();
    }
}
