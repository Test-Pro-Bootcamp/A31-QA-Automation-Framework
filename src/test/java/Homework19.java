import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends KoelTesting{

    @Test
    public void deletePlaylist() throws InterruptedException {
        Thread.sleep(2000);

        String playlistName = "Hw19 playlist";
        createPlaylist(playlistName);
        deletePlaylist(playlistName);

        WebElement playlistElement = null;
        try {
            playlistElement = driver.findElement(By.xpath(String.format("//section[@id='playlists']/ul/li/a[contains(text(),'%s')]", playlistName)));
        }catch (Exception e){}
        finally {
            Assert.assertEquals(playlistElement==null, true);
        }
    }
}
