import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21CH extends BaseTest {
    @Test
    public static void renamePlaylist() throws InterruptedException {

        login();
        choosePlaylist();
        doubleClickPlaylist();
        enterPlaylistName();
        Assert.assertTrue(IsPlaylistRenamed());
        Thread.sleep(2000);

    }
}
