import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        login("test123@test.com", "te$t$tudent");
        String playlistName = "HW20";
        createPlaylist();
        selectDesiredPlaylist(playlistName);
        deleteDesiredPlaylist();
        deletionMsg();
    }

    //Create a playlist
    public void createPlaylist() {
        String playlistName = "HW20";
        clickPlusIcon();
        clickNewPlaylistButton();
        createAPlaylistName(playlistName);
    }

    public void clickPlusIcon() {
        WebElement clickPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[class='fa fa-plus-circle create']")));
        clickPlusButton.click();
    }

    public void clickNewPlaylistButton() {
        WebElement selectNewPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        selectNewPlaylistButton.click();
    }

    public void createAPlaylistName(String playlistName) {
        WebElement newPlaylistField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        newPlaylistField.sendKeys(playlistName);
        newPlaylistField.submit();
    }

    //Navigate and select a playlist
    public void selectDesiredPlaylist(String playlistName) {
        WebElement selectAPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li[@class='playlist playlist']//a[contains(text(),'" + playlistName + "')]")));
        selectAPlaylist.click();
    }

    //Delete the selected playlist
    public void deleteDesiredPlaylist() {
        WebElement clickDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        clickDeleteButton.click();
    }

    //Validate the playlist is deleted
    public void deletionMsg() {
        WebElement successfulDeleteMsg = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='success show']")));
        Assert.assertTrue(successfulDeleteMsg.isDisplayed());
    }
}

