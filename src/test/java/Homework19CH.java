import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class Homework19CH extends BaseTest{

    @Test
    public static void DeletePlaylist() throws InterruptedException {

        login();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        deletePlaylist();
        Thread.sleep(3000);
        playlistIsDeleted();
        Thread.sleep(2000);
        Assert.assertTrue(playlistIsDeleted());

    }

}
