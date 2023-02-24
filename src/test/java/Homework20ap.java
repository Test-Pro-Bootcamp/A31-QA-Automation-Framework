import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20ap extends BaseTest {

    @Test
    public void playASongTest() throws InterruptedException {
        login("demo@class.com", "te$t$tudent");
        playSong();
        isSongPlaying();
    }



    public void playSong()   {
        WebElement nextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextButton.click();
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playButton.click();

    }

    public void isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

}
