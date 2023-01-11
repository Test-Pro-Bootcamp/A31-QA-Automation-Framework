import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("jenyag5@gmail.com", "te$t$tudent");
        Songs();
        song();
        playNextButton();
        playButton();
        soundBars();
    }
    public void Songs() {
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();
    }
    public void song() {
        WebElement songName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        songName.click();
    }
    public void playNextButton() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
    }
    public void playButton() {
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        playButton.click();
    }
    public void soundBars() {
        WebElement usersAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(usersAvatar.isDisplayed());
    }

    @Test
    public void deletePlaylist() throws InterruptedException{
        login("jenyag5@gmail.com", "te$t$tudent");
        playlist();
        verifyPlaylistDeleted();
    }
    public void playlist() throws InterruptedException {
        WebElement songs = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5) > a"));
        songs.click();
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
        delete.click();
    }
    public void verifyPlaylistDeleted() {
        WebElement imageDisplayed = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(imageDisplayed.isDisplayed());
    }

    @Test
    public void addSongtoPlaylist () throws InterruptedException {
        openloginUrl();
        enterEmail("jenyag5@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        allSongs();
        songName();
        addTo();
        playlistAuto();
        Assert.assertTrue(getSuccessPopUp().isDisplayed());
    }
    public void openloginUrl() {
        driver.get("http://bbb.testpro.io/");
    }
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void allSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"));
        allSongs.click();
    }
    public void songName() throws InterruptedException {
        WebElement songName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        songName.click();
    }
    public void addTo() throws InterruptedException {
        WebElement addTo = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
        addTo.click();
    }
    public void playlistAuto() throws InterruptedException {
        WebElement playlistAuto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(5)")));
        playlistAuto.click();
    }
    public WebElement getSuccessPopUp() {
        return driver.findElement(By.cssSelector("div[class='success show']"));
    }
}

