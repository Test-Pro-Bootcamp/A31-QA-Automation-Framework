import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Homework20 extends BaseTest {

@Test
public void deletePlaylist() {
    login("guyvanalex4@gmail.com", "teststudent!1");
    playlist();
    verifyPlaylistDeleted();

}

    public void playlist() {
        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        myPlaylist.click();
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
        delete.click();
    }
    public void verifyPlaylistDeleted() {
        WebElement imageDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='success show")));
        Assert.assertTrue(imageDisplayed.isDisplayed());
    }



    @Test
    public void  playSong()  {
        login("guyvanalex4@gmail.com", "teststudent!1");
        Songs();
        Name();
        playNextBtn();
        playBtn();
        Assert.assertTrue(soundBar().isDisplayed());

    }
    public void Songs() {
        WebElement Songs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        Songs.click();

    }
    public void Name() {
        WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']/div[1]/div[1]/div[1]/table[1]/tr[1]/td[2]")));

    }
    public void playNextBtn() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextBtn.click();

    }
    public void playBtn() {
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playBtn.click();

    }
    public WebElement soundBar() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']")));

    }


    @Test
    public void addSongtoPlaylist()  {
        login("guyvanalex4@gmail.com", "teststudent!1");
        clickSubmit();
        allSongs();
        songName();
        addTo();
        myPlaylist();
        Assert.assertTrue(getSuccessPopUp().isDisplayed());

    }

    public void allSongs()  {
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();

    }
    public void songName() {
        WebElement songName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[25]/td[2]")));
        songName.click();

    }
    public void addTo() {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
        addTo.click();

    }
    public void myPlaylist () {
        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist")));
        myPlaylist.click();

    }
    public WebElement getSuccessPopUp() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='success show']")));

    }
}

