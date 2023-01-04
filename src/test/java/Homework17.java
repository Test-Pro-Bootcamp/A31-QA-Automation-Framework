import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public static void addSongPlaylist() {
        //Precondition 1 : Chrome browser
        navigateToPage();
        //Log in with your credentials
        provideEmail("anupapeter@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Add song to playlist
        //Goto Songs page
        String url2 = "https://bbb.testpro.io/#!/songs";
        driver.get(url2);
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Find and Click Song
        WebElement song = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]//td[contains(text(),\"Episode 2\")]"));
        song.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Click 'AddTo'
        WebElement addToBtn = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]//button[@class=\"btn-add-to\"]"));
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}
        addToBtn.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Find Playlist and Click Playlist
        WebElement selectPlayList = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]//li[contains(text(),\"PlayJan4\")]"));
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}
        selectPlayList.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //////////Assert : If the song is present in the playlist
        // Click on the playlist used above
        WebElement playList = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[contains(text(),\"PlayJan4\")]"));
        playList.click();
        try {Thread.sleep(3000);}
        catch(InterruptedException e){}

        //Look for the song added in the playlist
        WebElement songAdded = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]//td[contains(text(),\"Episode 2\")]"));
        Assert.assertTrue(songAdded.isDisplayed());

    }
}
