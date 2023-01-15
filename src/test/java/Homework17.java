import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Homework17 extends BaseTest {
    //1. Create a new file Homework17.java with @Test annotation in IntelliJ IDEA.
    //2. Create a test case addSongToPlaylist() using @Test annotations and the helper/reusable methods we created.
    //3. Navigate to "https://bbb.testpro.io/".
    //4. Log in with your credentials.
    //5. Add a song to a playlist.
    //6. Validate that there is a song added.
    //7. Create a new branch and commit your changes.
    //8. Push your code to a remote repository.
    //9. Create a pull request.
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        // Navigate to Koel and login
        navigateToPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        provideEmail("rahwageb4@gmail.com");
        providePassword("texaspro2022!");
        clickSubmit();

        // Click on allsongs
        WebElement allSongs = driver.findElement(By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a"));
        allSongs.click();

        // Generate random number
        Random rand = new Random();
        int randomSong = rand.nextInt(100) + 2;

        // click on a random song from the list
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr["+ randomSong +"]"));
        firstSong.click();

        // Select add button
        WebElement addSelectedSong = driver.findElement(By.cssSelector("button.btn-add-to"));
        addSelectedSong.click();

        // Add the song in Test playlist
        WebElement playlistToAdd = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        playlistToAdd.click();

        // Check if the test is successful by checking pop up message
        WebElement songAddedMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        Assert.assertTrue(songAddedMessage.isDisplayed());

        //close chrome
        driver.quit();
    }

}
