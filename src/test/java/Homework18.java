
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Homework18 extends BaseTest {

    @Test

    public static void playSong () throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000);
        login("terrence.regis@gmail.com", "te$t$tudent");
        Thread.sleep(2000);

        selectSongList();
        Thread.sleep(2000);

        doubleClickOnSong();
        Thread.sleep(5000);

        isSongPlaying();
        Thread.sleep(2000);
    }

        public static void selectSongList() {
            WebElement allSongs = driver.findElement(By.cssSelector("[href='#!/songs']"));
            allSongs.click();

        }

        public static void doubleClickOnSong() {
            Actions act = new Actions(driver);
            WebElement song = driver.findElement(By.xpath("//tr/td[contains(text(), 'Take my Hand - Piano')]"));
            act.doubleClick(song).perform();
        }


         public static void isSongPlaying() {
             WebElement soundBar = driver.findElement(By.cssSelector("[class='bars']"));
             Assert.assertTrue(soundBar.isDisplayed());
         }





}
