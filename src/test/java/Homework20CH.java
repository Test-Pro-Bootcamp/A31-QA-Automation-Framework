import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20CH extends BaseTest{

    @Test
    public static void DeletePlaylist() {

        login();
        choosePlaylist();
        deletePlaylist();
        playlistIsDeleted();

        Assert.assertTrue(playlistIsDeleted());

    }
}

