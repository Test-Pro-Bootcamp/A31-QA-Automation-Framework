package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    By successMsg = By.cssSelector("div.success.show");
    By selectFirstSong = By.cssSelector("section#songsWrapper tr:nth-child(1) td.title");
    By addToButton = By.cssSelector("button[class='btn-add-to']");
    By choosePlaylistName = By.cssSelector("li[class = 'playlist']");
    By soundBarIcon = By.cssSelector("img[alt='Sound bars']");

    public AllSongsPage (WebDriver givenDriver) { super(givenDriver); }

    public void addSongToPlaylist () {
        click(selectFirstSong);
        click(addToButton);
        click(choosePlaylistName);
    }

    public void playSelectedSong() {
        doubleClick(driver.findElement(selectFirstSong));
    }

    public boolean isPlaying() {
        return waitVisible(soundBarIcon);
    }

    public boolean getSuccessMsg () {
        return waitVisible(successMsg);
    }
}
