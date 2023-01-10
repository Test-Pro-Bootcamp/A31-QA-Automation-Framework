import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {

        login("pooja.bankar@testpro.io","te$t$tudent");
        clickSubmit();
        selectExistingPlaylist();
        selectDeletePlaylist();
        Assert.assertTrue(isPlaylistDeletedMessageDisplayed());


    }

    //Selecting existing playlist
    public void selectExistingPlaylist() throws InterruptedException {
        WebElement existingPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]"));
        existingPlaylist.click();
        Thread.sleep(2000);
    }

    //Selecting Delete Playlist Option
    public void selectDeletePlaylist() throws InterruptedException {
        WebElement deletePlaylistOption = driver.findElement(By.cssSelector("button.del.btn-delete-playlist"));
        deletePlaylistOption.click();
        Thread.sleep(2000);
    }

    //Validating Playlist is deleted.
    public boolean isPlaylistDeletedMessageDisplayed() {
        WebElement playlistDeletedMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return playlistDeletedMessage.isDisplayed();
    }
}

