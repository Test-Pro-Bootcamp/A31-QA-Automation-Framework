package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends KoelTesting{

    @Test
    public void deletePlaylist(){
        String playlistName = "Hw19 playlist";
        homePage.createPlaylist(playlistName);
        homePage.deletePlaylist(playlistName);

        WebElement playlistElement = null;
        try {
            playlistElement = basePage.checkElement(By.xpath(String.format("//section[@id='playlists']/ul/li/a[contains(text(),'%s')]", playlistName)));
        }catch (Exception e){}
        finally {
            Assert.assertEquals(playlistElement==null, true);
        }
    }
}
