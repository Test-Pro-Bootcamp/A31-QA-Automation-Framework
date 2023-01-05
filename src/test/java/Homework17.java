import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlayList() throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000);
        provideEmail("terrence.regis@gmail.com");
        Thread.sleep(2000);

        providePassword("te$t$tudent");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);


        WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSongs.click();
        Thread.sleep(2000);

        WebElement song = driver.findElement(By.xpath("//tr/td[contains(text(), 'Take my Hand - Piano')]"));
        song.click();
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        button.click();
        Thread.sleep(2000);

        WebElement playListName = driver.findElement(By.xpath("//ul/li[contains(text(), 'Playlist1')]"));
        playListName.click();
        Thread.sleep(5000);

       driver.findElement(By.cssSelector("[class='success show']")).isDisplayed();




    }
}

       


















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
