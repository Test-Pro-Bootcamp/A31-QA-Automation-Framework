package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends KoelTesting{

    @Test (description = "Renaming a users created playlist")
    public  void renamePlaylist()
    {
        String  playlistName= "Test playlist";
        String newPlaylistName = "Renamed";
        homePage.createPlaylist(playlistName);
        homePage.renamePlaylist(playlistName,newPlaylistName);
        WebElement element = homePage.findElement(By.xpath("//div[contains(text(),'Updated playlist')]"));      //green popup for playlist rename verification
        Assert.assertTrue(element.isDisplayed());
        homePage.deletePlaylist(newPlaylistName);
    }
}
