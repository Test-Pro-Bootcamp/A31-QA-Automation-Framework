import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongtoPlaylist() throws InterruptedException {
        url();
        inputEmail("guyvanalex4@gmail.com");
        inputPassword("teststudent!1");
        clickSubmit();
        allSongs();
        songName();
        addTo();
        myPlaylist();
        Assert.assertTrue(getSuccessPopUp().isDisplayed());

    }

    public void url() {
        driver.get("http://bbb.testpro.io/");
    }

    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }
    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void allSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("#sidebar > section.music > ul > li:nth-child(3) > a"));
        allSongs.click();
        Thread.sleep(2000);
    }
    public void songName() throws InterruptedException {
        WebElement songName = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[25]/td[2]"));
        songName.click();
        Thread.sleep(2000);
    }
    public void addTo() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void myPlaylist () throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.cssSelector("#songsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li.playlist"));
        myPlaylist.click();
        Thread.sleep(4000);
    }
    public WebElement getSuccessPopUp() {
        return driver.findElement(By.cssSelector("div[class='success show']"));

    }
}
