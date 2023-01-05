
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest {


    @Test(enabled = true, description = "ch17homeworkaddsong")
    public void addSongToPlaylist()  {

        //goto Koel page-uname and pw-submit
        navigateToPage();
       provideEmail("kbetestack@gmail.com");
       providePassword("te$t$tudent");
        clickSubmit();

        //find and click on All Songs button
        WebElement allSongs = driver.findElement(By.className(".songs active"));
        allSongs.click();

        //find the song 'Frantic' and click on it
        WebElement chooseSong = driver.findElement(By.xpath("//td[contains(text(),'Frantic')]")) ;
        chooseSong.click();

        //find add to button and click
        WebElement addToPlaylist = driver.findElement(By.className(".btn-add-to"));
       addToPlaylist.click();

      //selecting a playlist to add song to and choose
       WebElement existPlaylist = driver.findElement(By.cssSelector("#songsWrapper li.playlist"));
       existPlaylist.click();

       //confirm song in playlist
        WebElement addedSong = driver.findElement(By.cssSelector("#songsWrapper li.playlist"));
        Assert.assertTrue(addedSong.isDisplayed());




}
