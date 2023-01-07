import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18_PB extends BaseTest{
    /*
    1. Create a new file Homework18.java with @Test annotation in IntelliJ IDEA.
    2. Create a test case playSong() using @Test annotations.
    3. Use the helper/reusable methods we created.
    4. Create a new config XML file for the test case.
    5. Specify the method to be ran in the XML file.
    6. Navigate to "https://bbb.testpro.io/".
    7. Log in with your credentials.
    8. Play a song.
    9. Validate that a song is playing.
    10. Create a new branch and commit your changes.
    11. Push your code to a remote repository.
    12. Create a pull request.*/


    @Test
    public void playSongTest() throws InterruptedException{

        navigateToPage();
        login("pooja.bankar@testpro.io", "te$t$tudent");
        clickSubmit();
        clickAllSongsTab();
        selectAndPlaySong();
        isSongPlaying();
    }

  //Locate All Songs
           public void clickAllSongsTab() throws InterruptedException {
               WebElement allSongsTabField = driver.findElement(By.cssSelector("a.songs"));
                allSongsTabField.click();
                Thread.sleep(3000);
       }

        // Locate first song from All Songs List,double click and play
        public void selectAndPlaySong() throws InterruptedException{

            Actions actions = new Actions(driver);
            WebElement selectFirstSongField = driver.findElement(By.xpath("//*[@id='songsWrapper']//div[1]/table/tr[1]/td[2]"));
            actions.doubleClick(selectFirstSongField).build().perform();
           Thread.sleep(3000);
       }

       //Validate song is playing
        public void isSongPlaying(){
         WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
            Assert.assertTrue(soundbar.isDisplayed());
        }
}
