package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");

    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");

    By playlistInputField = By.cssSelector("input[name='name']");

    public HomePage( WebDriver givenDriver) {

        super(givenDriver);
    }

    public void doubleClickFirstPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstPlaylist));
        doubleClick(firstPlaylist);
    }

    public void enterPlaylistName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistInputField));
        WebElement playlistNameField = findElement(playlistInputField);
        playlistNameField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);

    }

    public boolean doesPlaylistExist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" +playlistName+"']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" +playlistName+ "']"));
        return playlistElement.isDisplayed();
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
}


