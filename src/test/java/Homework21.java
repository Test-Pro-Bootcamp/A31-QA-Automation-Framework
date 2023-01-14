import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() {
        login("guyvanalex4@gmail.com", "teststudent!1");
        myPlaylist();
        changePlaylistName();
        verifyNameChanged();
    }
    public void myPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        WebElement webElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        actions.doubleClick(webElement).perform();
    }
    public void changePlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a" , Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Homework21");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean verifyNameChanged() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Homework21']"));
        return playlistElement.isDisplayed();
    }
}


