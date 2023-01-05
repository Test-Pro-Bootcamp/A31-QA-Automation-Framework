import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends LoginTests {

    public static WebDriver driver = null;
    @Test(priority = 0, description = "addSongToPlaylist")
    public static void addSongToPlaylist() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        //open url
        driver.get(url);
        //validate
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //find the email field
        provideEmail();
        providePassword();
        clickSubmit();
        
        

            //find all songs folder
            WebElement allSong = driver.findElement(By.cssSelector("[class='songs']"));
            //click to all songs folder
            allSong.click();
        //find a song
        WebElement chooseSong = driver.findElement(By.xpath("//td[normalize-space()='Dark Days']"));
        //click to song
        chooseSong.click();
        Thread.sleep(2000);
        //find add to
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        //click to add to
        addTo.click();
        //find Testng playlist
        WebElement testngPlaylist = driver.findElement(By.cssSelector("#songsWrapper li.playlist"));
        //click to the playlist
        testngPlaylist.click();
        //validate
        WebElement addedSong = driver.findElement(By.xpath("//td[normalize-space()='Dark Days']"));
        Assert.assertTrue(addedSong.isDisplayed());

        }

}