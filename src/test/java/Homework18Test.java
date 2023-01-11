import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework18Test extends BaseTest {
    public static  boolean isSongPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return songIsPlaying.isDisplayed();
    }
    @Test(description = "Log in with Valid User Info")
    public static void playSong() throws InterruptedException {
        logIn("skyeman75@gmail.com", "te$t$tudent");
        verifyLogIn();
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        WebElement playSongButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        Thread.sleep(5000);
        playSongButton.click();
        Assert.assertTrue(isSongPlaying());
    }
}


