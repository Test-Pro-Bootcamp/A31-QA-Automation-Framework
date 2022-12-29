import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{


    @Test
    public void addSongToPlaylist() throws InterruptedException {

        openLogUrl();
        login();
        createPlaylist();
        addSongToThePlaylist();
        validateSongIsAdded ();

    }

}
