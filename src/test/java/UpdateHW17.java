import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateHW17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification = "Added 1 song into";

        navigateToPage();

        provideEmail("demo@class.com");

        providePassword("te$t$tudent");

        clickSubmit();
        Thread.sleep(2000);

        searchSong("Pluto");

        viewAllSearchResults();

        selectFirstSongResult();

        clickAddToButton();

        choosePlaylist("Test");

        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));

        Assert.assertTrue(isNotificationPopUpPresent());
    }
}
