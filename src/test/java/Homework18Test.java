import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework18Test extends BaseTest {
    public static  boolean isSongPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return songIsPlaying.isDisplayed();
    }
    @Test(description = "Log in with Valid User Info")
    public static void playSong(){
        logIn("skyeman75@gmail.com", "te$t$tudent");
        verifyLogIn();
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-next-btn']"))).click();
        Assert.assertTrue(isSongPlaying());
    }
}


