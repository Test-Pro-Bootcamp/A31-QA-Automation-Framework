import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        openLoginUrl();
        enterEmail("pavelguyvan@gmail.com");
        enterPassword("te$t$tudent1");
        clickSubmit();
        allSongs();
        songName();
        addTo();
        playListpg();
        Assert.assertTrue(getSuccessShow().isDisplayed());
    }
    public void openLoginUrl(){
        driver.get("https://bbb.testpro.io/");
    }
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void allSongs() throws InterruptedException{
        WebElement allSongs = driver.findElement(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"));
        allSongs.click();
        Thread.sleep(2000);
    }
    public void songName() throws InterruptedException{
        WebElement songName = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        songName.click();
        Thread.sleep(2000);
    }
    public void addTo() throws InterruptedException{
        WebElement addTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void playListpg() throws InterruptedException{
        WebElement playListpg = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        playListpg.click();
        Thread.sleep(2000);
    }
    public WebElement getSuccessShow(){
        return driver.findElement(By.cssSelector("[class= 'success show']"));
    }

}
