import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkNineteen extends BaseTest {

    @Test
    public void deletePlaylistTest() throws Exception {
        String playlistName = "test19";

        login("ainurbilyalova818@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys("test19", Keys.ENTER);


        WebElement test19 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='" + playlistName + "']")));
        test19.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();

        Thread.sleep(2000);
        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

        for (WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals(playlistName)) {
                Assert.assertTrue(false);
            }
        }
    }
}