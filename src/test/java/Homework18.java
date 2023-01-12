import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(enabled = true)
    public void playASongTest() {
        navigateToPage("https://bbb.testpro.io/");
        login("shalinibaronia@gmail.com", "te$t$tudent");
        playSong();
        songIsPlaying();
    }

    public void playSong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@title='Play next song']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public void songIsPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
}
