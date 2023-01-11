import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Homework19 extends MyBaseTest {

    public void removeAPlaylist() throws InterruptedException{
        login("ghoulishgirl@hotmail.com", "te$t$tudent");
        choosePlaylist();
        deletePlaylistBtn();
        WebElement deletedPlaylistMsg = isPlaylistGone();
        Assert.assertTrue(deletedPlaylistMsg.isDisplayed());
    }

    public void choosePlaylist() {
        WebElement selectPlaylist = driver.findElement(By.xpath("//li[@class ='playlist playlist']"));
        selectPlaylist.click();
    }

    public void deletePlaylistBtn()throws InterruptedException{
        WebElement delBtn = driver.findElement(By.xpath("//button[@class = 'del btn-delete-playlist']"));
        delBtn.click();
        Thread.sleep(2000);

    }
    public WebElement isPlaylistGone(){
        return driver.findElement(By.cssSelector("div.success.show"));

    }
}