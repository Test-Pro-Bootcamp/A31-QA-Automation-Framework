import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;

public class SeleniumTechniques extends BaseTest {


    //      context click (sometimes koel page does not load completely, re-run the test)
    @Test (enabled = true)
    public void playSong()   {
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.logIn();
        allSongsPage.chooseAllSongsList();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlay();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

    //      renames playlist using Actions double click (Pre-requisite - create at least one playlist)
    @Test (enabled = false)
    public void renamePlaylist() throws InterruptedException {
        login();
        doubleClickChoosePlaylist();
        //Thread.sleep(5000);
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
        //Thread.sleep(2000);

    }
    //    displays all songs in the playlist (Pre-requisite - create at least one playlist)
    @Test (enabled = false)
    public void listOfSongsWebElements() {
        login();
        choosePlaylist();
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongsInPlaylist())));
    }

    @Test (enabled = true)
    public void hoverOverPlayBtn() {
        LoginPage loginPage2 = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage2.logIn();
        allSongsPage.chooseAllSongsList();
        basePage.hoverToPlayBtn();
        Assert.assertTrue(basePage.hoverToPlayBtn().isDisplayed());
    }


    //    helper methods
//    public void chooseAllSongsList() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
//    }

//    public void contextClickFirstSong() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
//        actions.contextClick(firstSong).perform();
//    }

//    public void choosePlay() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
//    }

//    public boolean isSongPlaying() {
//        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
//        return soundBarVisualizer.isDisplayed();
//    }

    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
    public void enterPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
//        clear() does not work, element has an attribute of "required"
//            workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Summer Songs");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Summer Songs']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Summer Songs']"));
        return playlistElement.isDisplayed();
    }

    public int countSongsInPlaylist() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " + countSongsInPlaylist());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }
    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    //hover to play button/controls
//    public WebElement hoverToPlayBtn(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
//        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
//        actions.moveToElement(playButton).perform();
//        return  playButton;
//}


}









