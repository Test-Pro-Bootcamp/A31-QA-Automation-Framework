import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
@Test
public void deletePlaylist() throws InterruptedException{
    login("jenyag5@gmail.com", "te$t$tudent");
    playlist();
    verifyPlaylistDeleted();
}
  public void playlist() throws InterruptedException {
      WebElement songs = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5) > a"));
       songs.click();
       WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button")));
       delete.click();
    }
    public void verifyPlaylistDeleted() {
    WebElement imageDisplayed = driver.findElement(By.cssSelector("div[class='success show']"));
    Assert.assertTrue(imageDisplayed.isDisplayed());
    }
}
