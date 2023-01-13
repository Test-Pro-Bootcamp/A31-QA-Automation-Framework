import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException {
        login("shalinibaronia@gmail.com","te$t$tudent");
        doubleClickPlaylist();
        enterPlaylistName();
        confirmRenamedPlaylist();
    }

    public void doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Testplaylist']")));
        WebElement doubleClickPlaylist = driver.findElement(By.xpath("//a[normalize-space()='Testplaylist']"));
        doubleClickPlaylist.click();
        action.doubleClick(doubleClickPlaylist).perform();
    }

    public void enterPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-testid ='inline-playlist-name-input']")));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("newTestPlaylist");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void confirmRenamedPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'newTestPlaylist')]")));
        WebElement renamedPlaylist = driver.findElement(By.xpath("//a[contains(text(),'newTestPlaylist')]"));
        Assert.assertTrue(renamedPlaylist.isDisplayed());
    }
}

