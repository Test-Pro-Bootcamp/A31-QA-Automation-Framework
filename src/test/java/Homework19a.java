import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public  class Homework19a extends BaseTest{


    @Test
    public void DeleteAPlaylistTest() throws InterruptedException{
        String playlistName = "Timelaps";


        login("demo@class.com","te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[@title='Create a new playlist'])");

        WebElement newPlaylist = driver.findElement(By.cssSelector("li[text()='New Playlist']"));
        newPlaylist.click();

        WebElement nameField = driver.findElement(By.cssSelector("input[@name='name']"));
        nameField.clear();
        nameField.sendKeys("playlistName", Advice.Enter);

        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i/a[text()='+playlistName+']")));
        testPlaylist.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[@title='Delete this playlist']")));
        deletePlaylist.click();

        Thread.sleep(2000);
        List<WebElement> playlistNames = driver.findElements(By.cssSelector("section[@id='playlists']//li/a"));


            for(WebElement p : playlistNames) {
                String name = p.getText();
                if (name.equals(playlistName)) {
                    Assert.assertTrue(false);
                }
            }
    }


}
