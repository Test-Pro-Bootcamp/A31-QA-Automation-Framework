import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        //Open Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get Url
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("test123@test.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        //Click login button

        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);

        // User should be directed to the homepage

        WebElement userAvatar = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(userAvatar.isDisplayed());
        Thread.sleep(2000);

        //Create Playlist

        WebElement plusIcon = driver.findElement(By.xpath("i[@class='fa fa-plus-circle create']"));
        plusIcon.click();
        Thread.sleep(2000);

        WebElement newPlaylist = driver.findElement(By.xpath("li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
        Thread.sleep(2000);

        WebElement newPlaylistField = driver.findElement(By.xpath("input[@name='name']"));
        newPlaylistField.click();
        newPlaylistField.sendKeys("HW17");
        newPlaylistField.submit();
        Thread.sleep(2000);

        WebElement customPlaylist = driver.findElement(By.xpath("a[text()='HW17']"));
        Assert.assertTrue(customPlaylist.isDisplayed());
        Thread.sleep(2000);

        driver.quit();

    }
}
