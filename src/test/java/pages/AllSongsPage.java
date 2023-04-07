package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    public Actions action = null;
    public AllSongsPage(WebDriver givenDriver) { super(givenDriver);}


    public void contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        action = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }

    public void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }



}
