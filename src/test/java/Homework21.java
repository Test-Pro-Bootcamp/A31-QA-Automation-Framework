import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist() {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Original Playlist");
        renameCustomPlaylist("Original Playlist", "Edited Playlist");

        Assert.assertTrue(isUpdatedMsg());
    }
}
