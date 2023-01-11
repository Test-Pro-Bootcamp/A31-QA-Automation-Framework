import org.testng.annotations.Test;
public class Homework19 extends BaseTest {
    @Test
    public static void deletePlaylist() throws InterruptedException {
        login("sandra.geche@gmail.com", "te$t$tudent");
        addPlaylist();
        newPlaylist();
        nameField();
        testPlaylist();
        deleteButton();
        playlistNotExist();
    }
}
