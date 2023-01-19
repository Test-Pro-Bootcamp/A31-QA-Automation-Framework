package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends KoelTesting{

    @Test
    public void addSongToPlaylist()
    {
        String playlist = "My Test Playlist";
        String song = "Algorithms";

        homePage.createPlaylist(playlist);        //Create a new user playlist
        homePage.clickTabInYourMusic("songs");      //Go to "all songs" tab
        allSongsPage.addSongInPlaylist(song, playlist);

        //verify the song has been added to the playlist
        WebElement songInPlaylist = null;
        try {
            songInPlaylist = basePage.checkElement(By.xpath("//section[@id='playlistWrapper']/div/div/div/table/tr/td[contains(text(), 'Algorithms')]"));
        }
        catch (Exception e){}
        finally{
            Assert.assertEquals((songInPlaylist!=null && songInPlaylist.isDisplayed()==true) , true, "ERROR: The playlist is either empty or an unexpected song was added");
        }

        homePage.deletePlaylist(playlist);
    }

}
