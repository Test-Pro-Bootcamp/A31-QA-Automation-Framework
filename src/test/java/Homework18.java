import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public static void playASongTest() throws InterruptedException {
        launchBrowser(url);
        login("demo@class.com", "te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);

//        //click 'play' button
        WebElement pressButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        pressButton.click();

        WebElement pressPlayButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        pressPlayButton.click();

        Thread.sleep(2000);

        WebElement validateSongIsPlaying = driver.findElement(By.cssSelector("div>img"));
        Assert.assertTrue(validateSongIsPlaying.isDisplayed());

        Thread.sleep(2000);

        closeBrowser();
    }

}
