import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {

        login("demo@class.com", "te$t$tudent");
        choosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());

    }
}
