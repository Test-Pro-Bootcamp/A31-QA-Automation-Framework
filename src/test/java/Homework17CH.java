import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17CH extends BaseTest {

    @Test
    public static void AddSongToPlaylist() throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        allSongsPage();
        firstSong();
        Thread.sleep(2000);
        addSongTo();
        Thread.sleep(2000);
        firstPlaylist();
        Thread.sleep(2000);
        validatePlaylist();
        Thread.sleep(2000);

    }

}
