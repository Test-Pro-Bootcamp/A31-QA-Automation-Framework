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
    public void doubleClickFirstPlaylist(){actions.doubleClick(); }

//    public void doubleClickChoosePlaylist() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
//        actions.doubleClick(playlistElement).perform();
//    }
    public void contextClickPlaylist(){contextClick(firstPlaylist); }

    public void enterPlaylistName(String playlistName){
        WebElement playlistNameTextField = findElement(playlistInputField);
        playlistNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameTextField.sendKeys(playlistName);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playListName){
        WebElement playListElement = driver.findElement(By.xpath("//a[text()='" +playListName+ "']"));
        return playListElement.isDisplayed();
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

}
