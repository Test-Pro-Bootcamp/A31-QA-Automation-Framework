import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    //You need to remove song Pluto from Test Pro Playlist before this test
    @Test
        public void addSongtoPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into";
        navigateToPage();
        provideEmail("zyabruk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Test Pro Playlist");
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));
        }
}
