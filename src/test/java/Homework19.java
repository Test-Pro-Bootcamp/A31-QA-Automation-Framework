import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        login("test123@test.com", "te$t$tudent");
        Thread.sleep(2000);

        selectDesiredPlaylist();
        deleteDesiredPlaylist();

        WebElement deletePlaylistMsg = getDeleteMsgDisplayed();
        Assert.assertTrue(deletePlaylistMsg.isDisplayed());
        Thread.sleep(2000);
    }

    //Navigate and select a playlist
    public void selectDesiredPlaylist() throws InterruptedException {
        WebElement selectAPlaylist = driver.findElement(By.cssSelector("[href='#!/playlist/35662']"));
        selectAPlaylist.click();
        Thread.sleep(2000);
    }

    //Delete the selected playlist
    public void deleteDesiredPlaylist() throws InterruptedException {
        WebElement clickDeleteButton = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        clickDeleteButton.click();
        Thread.sleep(2000);
    }

    //Validate the playlist is deleted
    public WebElement getDeleteMsgDisplayed() throws InterruptedException {
        return driver.findElement(By.cssSelector("div.success.show"));
    }
}
