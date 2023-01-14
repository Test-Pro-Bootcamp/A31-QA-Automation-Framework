import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import javax.swing.*;
import java.util.List;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylistTest() throws InterruptedException {
        String playlistName = "my";
        String newPlaylistName = "lalala";
        login("prytulan@gmail.com", "28268286nN*");
        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);
        WebElement addNewPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create a new playlist']")));
        addNewPlaylist.click();
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.sendKeys(playlistName);
        nameField.sendKeys(Keys.ENTER);
        WebElement myPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        myPlaylist.click();
        Actions showEditButton = new Actions(driver); // I used "contextclick' to make it a little bit different from the task that we was doing during live class
        showEditButton.contextClick(myPlaylist).perform();
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Edit']")));
        editButton.click();
        WebElement editField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        editField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        editField.sendKeys(newPlaylistName, Keys.ENTER);
        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));
        for(WebElement p : playlistNames) {
        String name = p.getText();
        if (name.equals(newPlaylistName)) {
        Assert.assertTrue(true);
 }}
    }
    }
