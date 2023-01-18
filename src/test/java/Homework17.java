import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        login("serge.uwiduhaye@gmail.com", "te$t$tudent");
        //Thread.sleep(2000);
        grabASong();

    }

    public void grabASong(){
        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//article[@data-test='song-card']")));
        WebElement myFirstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));

        Actions acts = new Actions(driver);
        acts.clickAndHold(song)
                .release(myFirstPlaylist)
                .build()
                .perform();

        myFirstPlaylist.click();
//        acts.dragAndDrop(song, playlist).build().perform();

    }
}
