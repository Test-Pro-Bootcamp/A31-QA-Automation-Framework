import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class Homework17 extends BaseTest {


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

