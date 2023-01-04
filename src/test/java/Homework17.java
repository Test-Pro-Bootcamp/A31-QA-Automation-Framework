import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public static void addSongToPlaylist()throws InterruptedException{

        launchBrowser();

        navigateToPage();
        provideEmail("ghoulishgirl@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();


        WebElement allSongs = driver.findElement(By.cssSelector("[class = 'songs']"));
       allSongs.click();

       WebElement chooseSong = driver.findElement(By.xpath("//td[normalize-space()='Ketsa - Beautiful']"));
       chooseSong.click();
       Thread.sleep(2000);

       WebElement choosePlaylist = driver.findElement(By.cssSelector("button[title='Add selected songs to…']"));
       choosePlaylist.click();

       WebElement pickPlaylist = driver.findElement(By.cssSelector("li[class='playlist']"));
       pickPlaylist.click();
       Thread.sleep(2000);

       WebElement addedSong = driver.findElement(By.xpath("//td[normalize-space()='Ketsa - Beautiful']"));
        Assert.assertTrue(addedSong.isDisplayed());

        closeBrowser();
    }

}
