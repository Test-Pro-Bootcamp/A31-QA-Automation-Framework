import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17jimmyvu extends BaseTest{
    @Test(enabled = true, priority = 1, description = "add a song to a playlist")
    public static void addSongToPlaylist() throws InterruptedException {
        navigateToPage();
        Thread.sleep(1000);
        login("jimmypvu@gmail.com", "te$t$tudent");
        Thread.sleep(1000);
        getASong();
        Thread.sleep(1000);

        WebElement song = driver.findElement(By.xpath("//section[@id='playlistWrapper']/div[@class='song-list-wrap main-scroll-wrap playlist']/div[@class='virtual-scroller scroller']/div[@class='item-container']/table[@class='items']/tr[@class='song-item']/td[contains(text(), 'Waiting On A Train')]"));
        Assert.assertTrue(song.isDisplayed());
    }

    public static void getASong() throws InterruptedException{
        WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs']"));
        allSongs.click();
        Thread.sleep(1000);

        WebElement song = driver.findElement(By.xpath("//td[contains(text(), 'Waiting On A Train')]"));
        song.click();
        Thread.sleep(1000);

        WebElement addToButton = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(1000);

        WebElement playlistFromDropdown = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playlistFromDropdown.click();
        Thread.sleep(1000);

        WebElement playlist = driver.findElement(By.xpath("//a[contains(text(), '3 renamed via patch')]"));
        playlist.click();
        Thread.sleep(1000);

    }
}
