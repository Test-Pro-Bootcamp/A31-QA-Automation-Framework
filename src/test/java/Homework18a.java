import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18a extends BaseTest{

    @Test
    public void playASongTest(){
        login("aidamtc@gmail.com", "te$t$tudent");
        playSong();
        isSongPlaying();
    }
    public void playSong(){
        WebElement playNxtBtn = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));

        playNxtBtn.click();
        playBtn.click();

    }
    public void isSongPlaying(){
      WebElement soundbar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundbar.isDisplayed());
    }

}
