import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    public static void Navigation(String url) {
        System.setProperty("webdriver.chrome.driver","c:\\\\chromedriver\\chromedriver.exe");
       // String url = "https://bbb.testpro.io/";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

    }

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        url = "https://bbb.testpro.io/";
        Navigation(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        grabASong();

    }

    public void grabASong(){
        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));

        Actions acts = new Actions(driver);
        acts.clickAndHold(song)
                .release(playlist)
                .build()
                .perform();

        playlist.click();
        acts.dragAndDrop(song, playlist).build().perform();

    }
}
