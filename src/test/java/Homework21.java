import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends KoelTesting{

    @Test
    public  void renamePlaylist()
    {
        String  playlistName= "Test playlist";
        String newPlaylistName = "Renamed";
        KoelTesting.createPlaylist(playlistName);
        KoelTesting.renamePlaylist(playlistName,newPlaylistName);
        WebElement elementWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Updated playlist')]")));
        Assert.assertTrue(elementWait.isDisplayed());
        deletePlaylist(newPlaylistName);
    }

}
