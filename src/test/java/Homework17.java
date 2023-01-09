import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homework17 extends KoelTesting{
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        Actions action = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();

        //Create a new user playlist
        KoelTesting.createPlaylist("My Test Playlist");
        Thread.sleep(1000);

        //Go to "all songs" tab
        KoelTesting.clickTabInYourMusic("songs");
        Thread.sleep(1000);

        //Select a song to be inserted
        action.click(driver.findElement(By.xpath("//td[contains(text(),'Algorithms')]"))).build().perform();
        Thread.sleep(1000);

        //Click the add to button
        action.click(driver.findElement(By.xpath("//button[@class='btn-add-to']"))).build().perform();
        Thread.sleep(1000);

        //Choose the created playlist, to add the song to that playlist
        action.click(driver.findElement(By.xpath("//section[@id='songsWrapper']/header/div/div/section/ul/li[@class='playlist']"))).build().perform();
        Thread.sleep(1000);

        //Click tab for the created playlist
        action.click(driver.findElement(By.xpath("//section[@id='playlists']/ul/li/a[contains(text(),'My Test Playlist')]"))).build().perform();
        Thread.sleep(1000);


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
