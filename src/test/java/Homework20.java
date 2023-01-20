import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Homework20 extends BaseTest {
    //1. Create a new file Homework20.java with @Test annotation in IntelliJ IDEA.
    //2. Refactor your code - implement Explicit waits.
    //3. Remove all implementations of Thread.sleep.
    //4. Make sure your code runs without failures.
    //5. Create a new branch and commit your changes.
    //6. Push your code to a remote repository.
    //7. Create a pull request.

    @Test
    @Parameters({"baseURL"})
    public void deletePlaylist() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Navigate to Koel and login
        provideEmail("rahwageb4@gmail.com");
        providePassword("texaspro2022!");
        clickSubmit();

        // Click on the playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[4]")));
        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[4]"));
        selectPlaylist.click();

        // Delete selected playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button")));
        WebElement deletePlaylist = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button"));
        deletePlaylist.click();

        // Validate that the playlist is deleted
        WebElement deleteMsg = driver.findElement(By.xpath(" //div[@class='success show']"));
        Assert.assertTrue(deleteMsg.isDisplayed());
    }
}
