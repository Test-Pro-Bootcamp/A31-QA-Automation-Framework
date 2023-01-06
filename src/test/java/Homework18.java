import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class Homework18 extends BaseTest {
    @Test(priority = 2, enabled = true)
    public void playSong() {
        navigateToPage();
        login("prytulan@gmail.com", "28268286nN*");
        clickSubmit();
        String homePage = "https://bbb.testpro.io/#!/home";
        driver.get(homePage);
        Actions playReactSong = new Actions(driver);
        WebElement reactorSong = driver.findElement(By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/ol/li[2]/article/span[2]/span[1]"));
        playReactSong.doubleClick(reactorSong).perform();
        Assert.assertTrue(reactorSong.isEnabled());
    }
    @Test(priority = 1, enabled = true)
       public void playSongTwo() {
        navigateToPage();
        login("prytulan@gmail.com", "28268286nN*");
        clickSubmit();
        String homePage = "https://bbb.testpro.io/#!/home";
        driver.get(homePage);
        Actions playLocoSong = new Actions(driver);
        WebElement LocoSong = driver.findElement(By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/ol/li[6]/article/span[2]/span[1]"));
        playLocoSong.doubleClick(LocoSong).perform();
        Assert.assertTrue(LocoSong.isEnabled());
    }
}