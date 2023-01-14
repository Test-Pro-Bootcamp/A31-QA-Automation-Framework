import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        login("pavelguyvan@gmail.com", "te$t$tudent1");
        playListpg();
        changePlayListName();
        verifyChanges();
    }
    public void playListpg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        WebElement webElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        actions.doubleClick(webElement).perform();
    }
    public void changePlayListName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("P Play");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean verifyChanges() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='P Play']"));
        return playlistElement.isDisplayed();
    }
}