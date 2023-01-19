package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends KoelTesting{

    @Test
    public  void renamePlaylist()
    {
        By updatedPlaylistGreenPopup =  By.xpath("//div[contains(text(),'Updated playlist')]");

        String  playlistName= "Test playlist";
        String newPlaylistName = "Renamed";
        homePage.createPlaylist(playlistName);
        homePage.renamePlaylist(playlistName,newPlaylistName);
        WebElement element = homePage.checkElement(updatedPlaylistGreenPopup);
        Assert.assertTrue(element.isDisplayed());
        homePage.deletePlaylist(newPlaylistName);
    }
}
