import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public static void addSongtoPlaylist() throws InterruptedException {

        navigateToPage();
        Thread.sleep(1000);
        login("ainurbilyalova818@gmail.com", "te$t$tudent");
        Thread.sleep(1000);
        getASong();


        WebElement song = driver.findElement(By.xpath("//section[@id='playlistWrapper']/div[@class='song-list-wrap main-scroll-wrap playlist']/div[@class='virtual-scroller scroller']/div[@class='item-container']/table[@class='items']/tr[@class='song-item']/td[contains(text(), 'Waiting On A Train')]"));
        Assert.assertEquals(song.getAttribute("innerHTML"), "HoliznaCC0 - Waiting On A Train");

    }
        public static void  getASong() throws InterruptedException{
            WebElement allSongs= driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
            allSongs.click();
            Thread.sleep(1000);

            WebElement song= driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
            song.click();
            Thread.sleep(1000);

            WebElement addToButton = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
            addToButton.click();
            Thread.sleep(1000);

            WebElement playlistFromDropdown = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
            playlistFromDropdown.click();
            Thread.sleep(1000);

            WebElement playlist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));

            playlist.click();
            Thread.sleep(1000);
        }



    }

