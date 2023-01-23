package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageTest extends BasePageTest {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePageTest(WebDriver givenDriver) {
        super (givenDriver);

    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("input[name='name']");

    public void doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
    }
    public void enterPlaylistName(String playlistName){
        WebElement playListNameTextField = driver.findElement(playlistInputField);
        playListNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playListNameTextField.sendKeys(playlistName);
        playListNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean verifyPlaylistExists(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
}


