package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AllSongPage extends BasePage {



        public AllSongPage(WebDriver givenDriver) {super(givenDriver);}
        //Page Factory locators

        //   @FindBy(css = "section.music a.songs");
        //   WebElement allSongs;
        public static void chooseAllSongsList(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
        }
        public static void contextClickFirstSong(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
            WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
            firstSong.click();
        }
        public boolean songIsPlaying(){
            WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
            return songIsPlaying.isDisplayed();
        }
        public static void addToPlayList(){
            WebElement addToPlayList = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > span > button.btn-add-to"));
            addToPlayList.click();
            WebElement favoritesPlayList = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.favorites"));
            favoritesPlayList.click();
        }
        public void playSong() {
            WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
            WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

            playNextButton.click();
            playButton.click();
        }
        public void isSongPlaying() {
            WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            Assert.assertTrue(soundBar.isDisplayed());
        }


}
