import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17mc extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);

        searchSong (songTitleKeyword "Dark Days");
        viewAllSearchResults ();
        selectFirstSongResult ();
        clickAddToButton ();
        choosePlaylist (playlistName "New Playlist");

        Assert.assertTrue(isNotificationPopupPresent());

    }
}
