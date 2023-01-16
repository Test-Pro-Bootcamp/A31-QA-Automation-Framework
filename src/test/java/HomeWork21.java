import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest {

    @Test
    public void renamePlaylistTest() {
        login("Pooja.bankar@testpro.io", "te$t$tudent");
        doubleClickRequiredPlaylist();
        enterNewPlayListName();
        Assert.assertTrue(isPlaylistRenamedMessageDisplayed());
    }

    //select required playlist
    public void doubleClickRequiredPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        WebElement requiredPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        act.doubleClick(requiredPlaylist).perform();
    }

    //Entering New playlistname
    public void enterNewPlayListName() {
        WebElement playlistNameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));//driver.findElement(By.cssSelector("input[name='name']"));
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistNameInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistNameInputField.sendKeys("Winter Sleepy songs");
        playlistNameInputField.sendKeys(Keys.ENTER);
    }

    //Validating Playlist name is renamed.
    public boolean isPlaylistRenamedMessageDisplayed() {
        WebElement playlistRenamedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alertify-logs.top.right")));//driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return playlistRenamedMessage.isDisplayed();
    }
}
