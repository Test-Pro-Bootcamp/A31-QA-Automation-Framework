import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.sql.DriverAction;
import java.time.Duration;


public class Homework17 extends BaseTest {

    String songTitle = "Pluto";

    String playlistName = "Test Pro Playlist";

    String newSongAddedNotification = "Added 1 Song into";


    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String newSongAddedNotification= "Added 1 song into";

       /* WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys("simplyd2d@gmail.com");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResults.click();

        WebElement viewAllFirstSongResults = driver.findElement(By.cssSelector("section#songResultWrapper tr.song-item td.title"));
        viewAllFirstSongResults.click();

        WebElement addTo = driver.findElement(By.xpath("//button[contains(text(),'Add To')]"));
        addTo.click();
        */
    }
}

        public void searchsong (String songTitle) throws InterruptedException {
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
            searchField.sendKeys(songTitle);
            searchField.click();

        }

        public void viewAllSearchResults () throws InterruptedException {
            WebElement viewAllSearchResults = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
            viewAllSearchResults.click();

        }

        public void selectViewAllFirstSongResults () throws InterruptedException {
            WebElement viewAllFirstSongResults = driver.findElement(By.cssSelector("section#songResultWrapper tr.song-item td.title"));
            viewAllFirstSongResults.click();
        }

        public void addTo () throws InterruptedException {
            WebElement addTo = driver.findElement(By.xpath("//button[contains(text(),'Add To')]"));
            addTo.click();

        }


       public static void addSongToPlaylist(String playlistName) throws InterruptedException {
           Thread.sleep(4000);
           viewAllSearchResults();
           Thread.sleep(3000);
           viewAllSearchResults();
           addTo();
           WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'" + playlistName + "')]"));
           playlistNameElement.click();
           Thread.sleep(2000);
       }

        public String newSongAddedNotification(){
            WebElement notificationText = driver. findElement(By.cssSelector("div.success.show"));
                notificationText.getText("True");

}
}

