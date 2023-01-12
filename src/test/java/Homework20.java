import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        playlist();
        verifyPlaylistDeleted();
    }

    public void playlist() throws InterruptedException {
        WebElement playListpg = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        playListpg.click();
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlistWrapper > header > div.song-list-controls > span > button")));
        delete.click();
    }

    public void verifyPlaylistDeleted() {
        WebElement imageDisplayed = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(imageDisplayed.isDisplayed());
    }

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        allSongs();
        songName();
        playNextButton();
        playButton();
        soundBars();
    }

    public void allSongs() throws InterruptedException {
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();
    }

    public void songName() throws InterruptedException {
        WebElement songName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        songName.click();
    }

    public void playNextButton() throws InterruptedException {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
    }

    public void playButton() throws InterruptedException {
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        playButton.click();
    }

    public void soundBars() {
        WebElement usersAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(usersAvatar.isDisplayed());
    }
}


