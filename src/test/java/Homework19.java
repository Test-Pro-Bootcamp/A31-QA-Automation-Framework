import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework19 extends BaseTest {
    //1. Create a new file Homework19.java with @Test annotation in IntelliJ IDEA.
    //2. Create a test case deletePlaylist() using @Test annotations.
    //3. Use the helper/reusable methods we created.
    //4. Use @Parameters for passing baseUrl from the TestNG config file to the tests.
    //5. Navigate to "https://bbb.testpro.io/".
    //6. Log in with your credentials.
    //7. Choose a playlist.
    //8. Delete the playlist
    //9. Validate that the playlist is deleted.
    //10. Create a new branch and commit your changes.
    //11. Push your code to a remote repository.
    //12. Create a pull request.
    @Test
    @Parameters({"baseURL"})
    public void deletePlaylist() throws InterruptedException {
        // Navigate to Koel and login
        provideEmail("rahwageb4@gmail.com");
        providePassword("texaspro2022!");
        clickSubmit();

        // Click on the playlist
        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[4]"));
        selectPlaylist.click();

        // Delete selected playlist
        WebElement deletePlaylist = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button"));
        deletePlaylist.click();

        // Validate that the playlist is deleted
        WebElement deleteMsg = driver.findElement(By.xpath(" //div[@class='success show']"));
        Assert.assertTrue(deleteMsg.isDisplayed());
    }
}