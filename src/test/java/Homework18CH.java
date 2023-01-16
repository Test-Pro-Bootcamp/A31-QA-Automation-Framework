import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18CH extends BaseTest{

    @Test
    public void playSongInHomepage() throws InterruptedException {
        login();
        Thread.sleep(2000);
        homePage();
        Thread.sleep(2000);
        mostPlayed();
        Thread.sleep(3000);
        playSong();
        Thread.sleep(2000);
        songIsPlaying();

        Assert.assertTrue(songIsPlaying());


    }

}
