package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    By songsPageLink = By.cssSelector("ul.menu a.songs");

    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    public WebElement playNextBtn;
    @FindBy(xpath = "//span[@data-testid='play-btn']")
    public WebElement playBtn;
    @FindBy(xpath = "//div[@data-testid='sound-bar-play']")
    public WebElement soundbar;

    public HomePage( WebDriver givenDriver) {

        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

    public SongsPage clickAllSongs(){
        WebElement songsPageBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(songsPageLink));
        songsPageBtn.click();
        return new SongsPage(driver);
    }

    public void playSong() {
        WebElement playButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        acts.moveToElement(playButton).click().perform();
    }

    public boolean songIsPlaying() {
        return soundbar.isDisplayed();
    }

    String title;
    List<String> playlistSongTitles;
    public void addSongToPlaylist() throws InterruptedException {
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//article[@data-test='song-card']/span[@class='main']")));
//        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[3]/a")));

        WebElement songTitleEle = song.findElement(By.xpath("./span/span"));
        title = songTitleEle.getText();

        acts.contextClick(song).perform();

        WebElement addToMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='menu song-menu']//li[@class='has-sub']")));

        acts.moveToElement(addToMenuItem).perform();

        List<WebElement> playlistsFromContextMenu = addToMenuItem.findElements(By.xpath(".//li"));
        String playlistTitle = playlistsFromContextMenu.get(playlistsFromContextMenu.size()-2).getText();
        playlistsFromContextMenu.get(playlistsFromContextMenu.size()-2).click();

        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']//li/a[contains(text(),'"+playlistTitle+"')]")));
        playlist.click();

        wait.until(ExpectedConditions.urlContains("playlist"));

        List<WebElement> playlistSongTitlesEles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("table.items td.title")));
        playlistSongTitles = new ArrayList<>();
        for(WebElement ele : playlistSongTitlesEles){
            playlistSongTitles.add(ele.getText());
        }
//        acts.dragAndDrop(song, playlist).build().perform();
    }

    public boolean isSongInPlaylist(){
        return playlistSongTitles.contains(title);
    }
}
