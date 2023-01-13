import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends KoelTesting{


    @Test
    public void playSong() throws InterruptedException {
        clickTabInYourMusic("songs");
        playTheSong("Reactor");
        WebElement soundBars = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Sound bars']")));
        Assert.assertEquals(soundBars.isDisplayed(), true);
    }
}
