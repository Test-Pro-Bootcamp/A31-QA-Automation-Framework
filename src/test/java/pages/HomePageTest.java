package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageTest extends BasePageTest {
    @FindBy(css="img.avatar" )
    WebElement userAvatarIcon;
    public HomePageTest(WebDriver givenDriver) {
        super (givenDriver);

    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) userAvatarIcon));
    }
    @FindBy(css=".playlist:nth-child(3)")
    WebElement firstPlaylist;
    @FindBy(css="input[name='name']")
    WebElement playlistInputField;

    public HomePageTest doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
        return this;
    }
    public void enterPlaylistName(String playlistName){
        WebElement playListNameTextField = driver.findElement((By) playlistInputField);
        playListNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playListNameTextField.sendKeys(playlistName);
        playListNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean verifyPlaylistExists(String playlistName){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
}


