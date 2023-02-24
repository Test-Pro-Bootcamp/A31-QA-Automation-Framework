import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() {
        login("demo@class.com", "te$t$tudent");
        playSong();
        isSongPlaying();
    }

    public void playSong() {
        WebElement playNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//i[@data-testid='play-next-btn']")));
        //WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//span[@data-testid='play-btn']")));
        //WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public void isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

}
