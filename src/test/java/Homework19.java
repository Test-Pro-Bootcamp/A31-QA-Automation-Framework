import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException{
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        playlist();
        verifyPlaylistDeleted();
    }
    public void playlist() throws InterruptedException{
        WebElement playListpg = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        playListpg.click();
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button")));
        delete.click();
    }
    public void verifyPlaylistDeleted(){
        WebElement imageDisplayed = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(imageDisplayed.isDisplayed());
    }
}

