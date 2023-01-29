import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {
    @Test
    @Parameters("BaseURL")
    public void deletePlaylistTest(String BaseURL) throws InterruptedException {
        String playlistName="Crystal";
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        addPlaylist(playlistName);
   //     addPlaylist("Diamond");
        WebElement playlist= choosePlaylist(playlistName);
        deletePlaylist(playlist);
        Thread.sleep(2000);
        validatePlaylistDeleted(playlistName);

    }

    public void addPlaylist(String newPlaylistName) throws InterruptedException {
        WebElement addButton = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        addButton.click();
        WebElement clickNewPlaylist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        clickNewPlaylist.click();
        WebElement playlistNameBox = driver.findElement(By.xpath("//input[@name='name']"));
        playlistNameBox.sendKeys(newPlaylistName);
        playlistNameBox.submit();
        Thread.sleep(2000);
    }

    public WebElement choosePlaylist(String playlistName) {
        WebElement playlist = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
        return playlist;

    }

    public void deletePlaylist(WebElement playlistToDelete) {
        Actions actions = new Actions(driver);
        actions.contextClick(playlistToDelete).perform();
       WebElement deleteButton = driver.findElement(By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]"));
       deleteButton.click();

    }

    public void validatePlaylistDeleted(String playlistNameToCheck) {
        List< WebElement> playlist = driver.findElements(By.xpath("//a[text()='"+playlistNameToCheck+"']"));
       Assert.assertEquals(playlist.size(),0);
    }

}
