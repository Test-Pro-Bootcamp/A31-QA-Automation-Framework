import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Homework17NLTests extends BaseTest {


    @Test
    public static void addSongToPlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        Thread.sleep(2000);

        //create new playlist
        WebElement newPlaylist = driver.findElement(By.cssSelector("[title='Create a new playlist']"));
        newPlaylist.click();

        WebElement clickNewPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        clickNewPlaylist.click();

        WebElement newPlaylistField = driver.findElement(By.cssSelector("input[name='name']"));
        newPlaylistField.click();
        newPlaylistField.clear();
        newPlaylistField.sendKeys("First Playlist");
        newPlaylistField.sendKeys(Keys.RETURN);

        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        //direct back to home screen
        WebElement homePage = driver.findElement(By.cssSelector("a[href='#!/home']"));
        homePage.click();

        //add song to playlist
        WebElement newSong = driver.findElement(By.cssSelector("span.play-count"));
        actions.contextClick(newSong).perform();

        Thread.sleep(2000);

        //hover to 'add to'
        WebElement hoverAddTo = driver.findElement(By.cssSelector("li.has-sub"));
        hoverAddTo.click();

        WebElement subMenuAdd = driver.findElement(By.cssSelector(".menu-add-to>li.playlist"));
        subMenuAdd.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div.success"));
        Assert.assertTrue(successMessage.isDisplayed());

        driver.quit();
    }

}