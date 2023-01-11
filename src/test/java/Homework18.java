import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        login("jenyag5@gmail.com", "te$t$tudent");
        allSongs();
        songName();
        playNextButton();
        playButton();
        soundBars();
    }
    public void allSongs() {
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();
    }
    public void songName() {
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
}