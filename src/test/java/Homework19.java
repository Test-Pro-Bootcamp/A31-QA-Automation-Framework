import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        createPlaylist("Empty Playlist");
        deleteEmptyPlaylist("Empty Playlist");

        Assert.assertTrue(isDeleted());
    }
}
