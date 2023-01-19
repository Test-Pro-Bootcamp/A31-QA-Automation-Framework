package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    @FindBy(css="section#songsWrapper tr:nth-child(1) td.title")
    WebElement firstSong;
    @FindBy(css="button[class='btn-add-to']")
    WebElement addToButton;

    //locator
    By soundBarIcon = By.cssSelector("img[alt='Sound bars']");

    public AllSongsPage (WebDriver givenDriver) { super(givenDriver); }

    public AllSongsPage selectFirstSong () {
        waitClick(firstSong);
        firstSong.click();
        return this;
    }

    public AllSongsPage addSongToPlaylist () {
        waitClick(addToButton);
        addToButton.click();
        firstPlaylist.click();
        return this;
    }

    public AllSongsPage playSelectedSong() {
        doubleClick(firstSong);
        return this;
    }

    public WebElement isPlaying() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarIcon));
    }

}
