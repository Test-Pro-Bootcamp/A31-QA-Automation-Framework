import org.openqa.selenium.By;
Homework17
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends LoginTests {

    public static WebDriver driver = null;
    @Test(priority = 0, description = "addSongToPlaylist")
    public static void addSongToPlaylist() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        //open url
        driver.get(url);
        //validate
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //find the email field
        provideEmail();
        providePassword();
        clickSubmit();
        
        

            //find all songs folder
            WebElement allSong = driver.findElement(By.cssSelector("[class='songs']"));
            //click to all songs folder
            allSong.click();
        //find a song
        WebElement chooseSong = driver.findElement(By.xpath("//td[normalize-space()='Dark Days']"));
        //click to song
        chooseSong.click();
        Thread.sleep(2000);
        //find add to
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        //click to add to
        addTo.click();
        //find Testng playlist
        WebElement testngPlaylist = driver.findElement(By.cssSelector("#songsWrapper li.playlist"));
        //click to the playlist
        testngPlaylist.click();
        //validate
        WebElement addedSong = driver.findElement(By.xpath("//td[normalize-space()='Dark Days']"));
        Assert.assertTrue(addedSong.isDisplayed());

        }

}

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        navigateToPage();
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        grabASong();

    }

    public void grabASong(){
        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));

        Actions acts = new Actions(driver);
        acts.clickAndHold(song)
                .release(playlist)
                .build()
                .perform();

        playlist.click();
//        acts.dragAndDrop(song, playlist).build().perform();

    }
}
 main
