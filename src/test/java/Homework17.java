import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlaylistTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Precondition
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Valid Email Login
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys("jrpasia@gmail.com");

        //Valid Password Login
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("B3n@iah2013");

        //Login Button
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
        Thread.sleep(3000);
        String homepageURL = "https://bbb.testpro.io/#!/home";
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);

        //Click All Songs Link
        WebElement allSongsPage = driver.findElement(By.cssSelector("[class='songs']"));
        allSongsPage.click();
        String allSongsURL = "https://bbb.testpro.io/#!/songs";
        Assert.assertEquals(driver.getCurrentUrl(), allSongsURL);

        //Click "Reactor" song
        WebElement reactorSong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[12]/td[2]"));
        reactorSong.click();

        //Click green "Add To" button
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();

        //Click "Morning Jam" Playlist
        WebElement morningJamLink = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[7]"));
        morningJamLink.click();

        //Validate "Reactor" song is added
        Thread.sleep(3000);
        WebElement morningJamPlaylist = driver.findElement(By.cssSelector("[href='#!/playlist/18754']"));
        morningJamPlaylist.click();
        WebElement reactorSongIsPresent = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[13]/td[2]"));
        Assert.assertTrue(reactorSongIsPresent.isDisplayed());
        driver.quit();








    }


}
