import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.*;


//1. Create a new file Homework17.java with @Test annotation in IntelliJ IDEA.
//
//        2. Create a test case addSongToPlaylist() using @Test annotations
//        and the helper/reusable methods we created.
//
//        3. Navigate to "https://bbb.testpro.io/".
//
//        4. Log in with your credentials.
//
//        5. Add a song to a playlist.
//
//        6. Validate that there is a song added.
//
//        7. Create a new branch and commit your changes.
//
//        8. Push your code to a remote repository.
//
//        9. Create a pull request.


public class Homework17 extends BaseTest {
}

    @BeforeSuite
    public static void addSongToPlaylist (){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailLink = driver.findElement(By.cssSelector("[type='email']"));
        emailLink.click();
        emailLink.sendKeys("mitchelterlecki@gmail.com");

        WebElement passwordLink = driver.findElement(By.cssSelector("[type='password']"));
        passwordLink.click();
        passwordLink.sendKeys("te$t$tudent");

        // WebElement for the login button or submit maybe?


      //  previously used driver for registration: Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        @Test
        //chosen song to add in playlist
        String songTitle = "Pluto";
        selectSong(songTitle);

        addSong();
        Assert.assertTrue(isSongAdded(songTitle), message: "Song titled" +songTitle+ "added to playlist");
        driver.quit();


    }
}