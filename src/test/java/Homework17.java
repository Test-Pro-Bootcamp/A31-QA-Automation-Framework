import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends MyBaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        provideEmail("serge.uwiduhaye@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Lobo");
        viewAllResults();

        selectFirstSong();
        clickAddToButton();
        choosePlaylist("My Songs");

        Assert.assertTrue(getNotificationPopUp().contains("Added 1 song into"));


    }
}
