import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        navigateToPage();
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        Thread.sleep(2000);
        allSongs();
        songName();
        playNextButton();
        playButton();
        soundBars();

    }
    public void allSongs() throws InterruptedException{
        WebElement allSongs = driver.findElement(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"));
        allSongs.click();
        Thread.sleep(2000);

    }
    public void songName() throws InterruptedException{
        WebElement songName = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        songName.click();
        Thread.sleep(2000);
    }
    public void playNextButton() throws InterruptedException{
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
        Thread.sleep(2000);
    }
    public void playButton() throws InterruptedException{
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(2000);
    }
    public void soundBars(){
        WebElement usersAvatar = driver.findElement(By.cssSelector("ing[alt='Sound bars']"));
        Assert.assertTrue(usersAvatar.isDisplayed());
    }
}

