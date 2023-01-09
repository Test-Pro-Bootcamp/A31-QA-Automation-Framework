import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public static void addSongToPlaylist() throws InterruptedException {
        navigateToPage();
        provideEmail("nguidry419@gmail.com");
        providePassword("PlanA2025!");
        clickSubmit();
        searchSong("Epic");
        Thread.sleep(2000);
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Awesome Mix Tape #6");
        Assert.assertTrue(isNotificationPopUpPresent());

    }
}
