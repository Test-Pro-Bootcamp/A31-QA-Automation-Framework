import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class Homework17 extends BaseTest {
        @Test (enabled = true, priority = 0, description = "addSongToPlayList")
        public static void addSongToPlayList() {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("prytulan@gmail.com");
            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("28268286nN*");
            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();
            String homePage = "https://bbb.testpro.io/#!/home";
            driver.get(homePage);
            Actions playSong = new Actions(driver);
            WebElement reactorSong = driver.findElement(By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/ol/li[2]/article/span[2]/span[1]"));
            playSong.doubleClick(reactorSong).perform();
            Actions openSubMenu = new Actions(driver);
            openSubMenu.contextClick(reactorSong).perform();
            WebElement addToMenu = driver.findElement(By.cssSelector("[class='has-sub']"));
            Actions a = new Actions(driver);
            a.clickAndHold(addToMenu).perform();
            WebElement addToLaLaLaPlaylist = driver.findElement(By.xpath("//*[@id='app']/nav/ul/li[4]/ul/li[7]"));
            addToLaLaLaPlaylist.click();
            WebElement lalalaPlaylist = driver.findElement(By.cssSelector("[href='#!/playlist/25202']"));
            lalalaPlaylist.click();
    }
}