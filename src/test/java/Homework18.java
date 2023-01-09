import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends KoelTesting{


    @Test
    public void playSong() throws InterruptedException {
        Thread.sleep(2000);
        clickTabInYourMusic("songs");
        playTheSong("Reactor");
        WebElement soundBars = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertEquals(soundBars.isDisplayed(), true);
    }
}
