import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.List;

public class Homework20 extends BaseTest {
    @Test
    @Parameters({"BaseURL"})
    public static void deletePlaylist()  {
        login("prytulan@gmail.com", "28268286nN*");
        clickSubmit();
        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);
        String playlistName = "my";
        WebElement addPlaylist = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        addPlaylist.click();
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='New Playlist']")));
        newPlaylist.click();
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        nameField.sendKeys("my");
        nameField.sendKeys(Keys.ENTER);
        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist']/a[text() = 'my']")));
        myPlaylist.click();
        WebElement deletePlaylistbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylistbutton.click();
      //  Thread.sleep(2000);
//        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));
//        for(WebElement p : playlistNames) {
//            String name = p.getText();
//            if (name.equals(playlistName)) {
//                Assert.assertTrue(true);
            }
       // }}
        }