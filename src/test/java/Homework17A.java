import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17A extends MyBaseTest{
//    public static WebDriver driver = new ChromeDriver();
//    we can remove this webdriver initialization


    @Test
    public void addSongtoPlaylist() throws InterruptedException {
        //login("simplyd2d@gmail.com","te$t$tudent");
    enterEmail("simplyd2d@gmail.com");
    enterPassword("te$t$tudent");
    clickSubmit();
    Thread.sleep(2000);

    searchSong("Take My Hand");
    Thread.sleep(2000);
    viewAllSearchResults();
    selectSong();
    clickAddToButton();
    selectPlaylistname("David");

       WebElement addedSongAlert = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(addedSongAlert.isDisplayed());

        //Assert.assertTrue(getNotificationText().contains("Added 1 song into"));
        /* Assert.assertTrue(isNotificationPopUpPresent();   This I am unsure off? */





    }




}


