import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class PlaylistTests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage lp = new LoginPage(getDriver());
        lp.logIn();

        HomePage hp = new HomePage(getDriver());
        hp.addSongToPlaylist();

        Assert.assertTrue(hp.isSongInPlaylist());
    }

    @Test
    public void DeletePlaylistTest() throws InterruptedException {
        String playlistName = "test playlist";

        login("demo@class.com", "te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        testPlaylist.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();

        Thread.sleep(2000);
        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

        for(WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals(playlistName)) {
                Assert.assertTrue(false);
            }
        }
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
