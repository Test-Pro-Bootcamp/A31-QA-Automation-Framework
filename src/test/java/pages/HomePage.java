package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    String playlistName = "Test Pro Playlist";
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement playListElement;
    @FindBy(css = "input[name='name']")
    WebElement playlistInputField;
    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public HomePage enterPlaylistName(String playlistName){
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }


    public HomePage doubleClickChoosePlaylist() {
        doubleClick(playListElement);
        return this;
    }
    public boolean doesPlaylistExist(){
        WebElement playListElement = driver.findElement(By.xpath("//a[text()='" +playlistName+ "']"));
        return playListElement.isDisplayed();
    }


}
