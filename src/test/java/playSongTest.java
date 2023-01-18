import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class playSongTest extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        allSongs();
        songName();
        playNextButton();
        playButton();
        soundBars();
    }
    public void allSongs() throws InterruptedException{
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a")));
        allSongs.click();
    }
    public void songName() throws InterruptedException{
        WebElement songName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        songName.click();
    }
    public void playNextButton() throws InterruptedException{
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
    }
    public void playButton() throws InterruptedException{
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        playButton.click();
    }
    public void soundBars(){
        WebElement usersAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Sound bars']")));
        Assert.assertTrue(usersAvatar.isDisplayed());
    }
}



