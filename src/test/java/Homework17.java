import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public static void AddSongToPlaylist () throws InterruptedException {


            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            Thread.sleep(2000);
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);


        WebElement emailfield = driver.findElement(By.cssSelector("[type ='email']"));
        emailfield.click();
        emailfield.sendKeys("tatsianahuryeva@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement button = driver.findElement(By.cssSelector("button[type = 'submit']"));
        button.click();

        WebElement allSongs = driver.findElement(By.xpath("//a[text()='All Songs']"));
        allSongs.click();

        WebElement song = driver.findElement(By.xpath("//td[text()='Mid-Air Machine - If It_s All I Do']"));
        song.click();

        WebElement add = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        add.click();

        WebElement buttonadd = driver.findElement(By.xpath("//li[contains(text(),'33')]"));
        buttonadd.click();

        WebElement playlist33 = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        playlist33.click();

        WebElement songicon = driver.findElement(By.xpath("//td[text()='Mid-Air Machine - If It_s All I Do']"));
        Assert.assertFalse(songicon.isDisplayed());

    }
}
