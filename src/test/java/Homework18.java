import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void  playSong() throws InterruptedException {
        navigateToPage();
        login("demo@class.com", "te$t$tudent");
        Thread.sleep(2000);
        selectSongToPlay();
        Thread.sleep(2000);
    }

    public void selectSongToPlay() {
        WebElement song = driver.findElement(By.cssSelector("[class='control control-play font-size-0']"));
        song.click();

    }

}
