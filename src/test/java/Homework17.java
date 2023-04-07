import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login();
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
