import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playaSongTest() {
        login("demo@class.com", "te$t$tudent");
        playSong();
        isSongPlaying();

        closeBrowser();
    }

}
