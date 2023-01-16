import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    public String playlistName = "test";

    @Test
    public void deletePlaylistTestUpdated() throws InterruptedException {
        login("pooja.bankar@testpro.io", "te$t$tudent");
        clickSubmit();
        createNewPlaylist();
        selectPlaylist();
        selectDeletePlaylistButton();
        Assert.assertTrue(isPlaylistDeletedMessageDisplayed());

    }

    //create New Playlist
    public void createNewPlaylist() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
    }


    //Selecting playlist
    public void selectPlaylist() throws InterruptedException {
        WebElement selectPlaylistLocator = driver.findElement(By.xpath("//li/a[text()='" + playlistName + "']"));
        wait.until(ExpectedConditions.visibilityOf(selectPlaylistLocator)).click();
        //existingPlaylist.click();
    }

    //Selecting Delete Playlist Option
    public void selectDeletePlaylistButton() throws InterruptedException {
        WebElement deletePlaylistOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylistOption.click();

    }

    //Validating Playlist is deleted.
    public boolean isPlaylistDeletedMessageDisplayed() {
        WebElement playlistDeletedMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return playlistDeletedMessage.isDisplayed();
    }
}



