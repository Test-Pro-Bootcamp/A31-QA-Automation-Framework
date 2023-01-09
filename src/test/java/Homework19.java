import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException{
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        playlist();
        verifyPlaylistDeleted();
        Thread.sleep(2000);
    }
    public void playlist() throws InterruptedException{
        WebElement playListpg = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        playListpg.click();
        Thread.sleep(2000);
        WebElement delete = driver.findElement(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button"));
        delete.click();
        Thread.sleep(2000);
    }
    public void verifyPlaylistDeleted(){
        WebElement imageDisplayed = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(imageDisplayed.isDisplayed());
    }
}

