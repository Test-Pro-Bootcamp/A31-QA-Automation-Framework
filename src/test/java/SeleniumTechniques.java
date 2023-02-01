import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class SeleniumTechniques extends BaseTest {
    By playListLocator = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputLocator = By.cssSelector("input[name='name']");
    By editPlayListLocator = By.xpath("//a[text()='Edited Playlist Name']");
    By playlistSelector = By.cssSelector("section#playlistWrapper td.title");
    By playBtnLocator = By.xpath("//span[@data-testid='play-btn']");

    //      context click (sometimes koel page does not load completely, re-run the test)
    @Test
    public void playSong()   {
        login("demo@class.com", "te$t$tudent");
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
    }

    //      renames playlist using Actions double click (Pre-requisite - create at least one playlist)
    @Test
    public void renamePlaylist() throws InterruptedException {
        login("demo@class.com", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
        Thread.sleep(2000);

    }
    //    displays all songs in the playlist (Pre-requisite - create at least one playlist)
    @Test
    public void listOfSongsWebElements() {
        login("demo@class.com", "te$t$tudent");
        choosePlaylist();
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongsInPlaylist())));
    }

    @Test
    public void hoverOverPlayBtn() {
        login("demo@class.com", "te$t$tudent");
        chooseAllSongsList();
        hoverToPlayBtn();
        Assert.assertTrue(hoverToPlayBtn().isDisplayed());

    }


    //    helper methods
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }

    public void contextClickFirstSong() {
        homePage.contextClick(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        // WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        // actions.contextClick(firstSong).perform();
    }

    public void choosePlay() {
        homePage.click(By.cssSelector("nav.menu.song-menu li.playback"));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    public void doubleClickChoosePlaylist() {
        homePage.findElement(playListLocator);
        // actions = new Actions(driver);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(playListLocator));
        // WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        homePage.doubleClick(playListLocator);
    }

    public void choosePlaylist() {
        homePage.click(playListLocator);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public void enterPlaylistName() {
        WebElement playlistInputField = homePage.findElement(playlistInputLocator);
        // WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Summer Songs");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        WebElement playlistElement = homePage.findElement(editPlayListLocator);
        return playlistElement.isDisplayed();
    }

    public int countSongsInPlaylist() {
        return driver.findElements(playlistSelector).size();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(playlistSelector);
        System.out.println("Number of songs found: " + countSongsInPlaylist());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }
    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    //hover to play button/controls
    public WebElement hoverToPlayBtn(){
        return homePage.moveToElement(playBtnLocator);
        // actions = new Actions(driver);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        // WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        // actions.moveToElement(playButton).perform();
        // return  playButton;

}


}









