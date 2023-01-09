import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HW18 extends BaseTest{


    @Test

    public void playSong() {
        login("zahinedu@gmail.com", "te$t$tudent");
        songPlaying();
        validatePlay();
    }


    public void songPlaying(){

       WebElement NextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
       WebElement playButton = driver.findElement(By.xpath(" //span[@data-testid='play-btn']"));

       NextButton.click();
        playButton.click();

        }

        public void validatePlay(){

       WebElement soundBar = driver.findElement(By.xpath(" //img[@alt='Sound bars']"));
            Assert.assertTrue(soundBar.isDisplayed());
        }


    }

