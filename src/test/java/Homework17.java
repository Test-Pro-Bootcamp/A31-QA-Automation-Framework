import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homework17 extends KoelTesting{
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        Actions action = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();

        //Create a new user playlist
        KoelTesting.createPlaylist("My Test Playlist");

        //Go to "all songs" tab
        KoelTesting.clickTabInYourMusic("songs");

        //Select a song to be inserted
        WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(),'Algorithms')]")));
        elementWait.click();

        //Click the add to button
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        elementWait.click();

        //Choose the created playlist, to add the song to that playlist
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']/header/div/div/section/ul/li[@class='playlist']")));
        elementWait.click();

        //Click tab for the created playlist
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']/ul/li/a[contains(text(),'My Test Playlist')]")));
        elementWait.click();

        //verify the song has been added to the playlist
        WebElement songInPlaylist = null;
        try {
           songInPlaylist = driver.findElement(By.xpath("//section[@id='playlistWrapper']/div/div/div/table/tr/td[contains(text(), 'Algorithms')]"));
        }
        catch (Exception e){}
        finally{
            softAssert.assertEquals((songInPlaylist!=null && songInPlaylist.isDisplayed()==true) , true, "ERROR: The playlist is either empty or an unexpected song was added");
        }

        KoelTesting.deletePlaylist("My Test Playlist" );

        softAssert.assertAll();
    }

}
