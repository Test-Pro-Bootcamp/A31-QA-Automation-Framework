import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework17Test extends BaseTest {

@Test
public void validLoginEmailPassword(){
    openLoginURL();
    enterEmail("skyeman75@gmail.com");
    enterPassword("te$t$tudent");
    clickButton();
    WebElement avatarIcon =driver.findElement(By.cssSelector("[alt='Avatar of student']"));
    Assert.assertTrue(avatarIcon.isDisplayed());
}
@Test
public void addSongToPlayList(){
    WebElement allSongs = driver.findElement(By.cssSelector("a[href*='#!/songs']"));
    allSongs.click();
    WebElement songSelect = driver.findElement(By.cssSelector("td.title"));
    songSelect.click();
    WebElement addSongButton = driver.findElement(By.cssSelector(".btn-add-to"));
    addSongButton.click();
    WebElement addSong =driver.findElement(By.cssSelector("a[href*='#!/playlist/20795']"));
    addSong.click();
}
}
