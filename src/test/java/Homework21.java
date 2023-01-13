import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

@Test
public void renamePlaylist() {
    login("jenyag5@gmail.com", "te$t$tudent");
    playlistAuto();
    changePlaylistName();
    verifyNameChanged();
}
    public void playlistAuto(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        actions.doubleClick(webElement).perform();
    }
    public void changePlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Sky");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean verifyNameChanged() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Sky']"));
        return playlistElement.isDisplayed();
    }

    }
