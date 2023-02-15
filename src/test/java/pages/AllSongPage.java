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

    @FindBy(css = "section#songsWrapper tr:nth-child(1) td.title")
    //".all-songs tr.song-item:nth-child(1)"
    WebElement firstSong;
    @FindBy(css = "section.music a.songs")
    WebElement allSongBtn;
    @FindBy(xpath = "//a[contains(text(), 'All Songs')]")
    WebElement allSongBtnXpath;
    @FindBy(css = "//div[@data-testid='sound-bar-play']")
    WebElement soundBar;
        @FindBy(css = "#songsWrapper > header > div.song-list-controls > span > button.btn-add-to")
    WebElement addToPlayList;
    @FindBy(css = "#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.favorites")
    WebElement favoritesPlayList;

    By soundBarIcon = By.cssSelector("img[alt='Sound bars']");


    public AllSongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void chooseAllSongsList() {
        waitClick(allSongBtnXpath);
        allSongBtnXpath.click();
    }

    public void contextClickFirstSong() {
        waitClick(firstSong);
        firstSong.click();
    }

    public WebElement songIsPlaying() {
        return
        wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarIcon));
    }

    public void addToPlayList() {
        waitClick(addToPlayList);
        addToPlayList.click();
        waitClick(favoritesPlayList);
        favoritesPlayList.click();
    }

    public void playSong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public AllSongPage isSongPlaying() {
        waitClick(soundBar);
        Assert.assertTrue(soundBar.isDisplayed());
        return this;
    }

    public AllSongPage selectFirstSong() {
        waitClick(firstSong);
        firstSong.click();
        return this;
    }

    public AllSongPage doubleClickFirstSong() {
        doubleClick(firstSong);
        return this;
    }

    public WebElement getAllSongBtnXpath() {
        return wait.until(ExpectedConditions.visibilityOf(allSongBtnXpath));
    }

}
