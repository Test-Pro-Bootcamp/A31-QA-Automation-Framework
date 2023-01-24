package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    //By userAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    //By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstPlaylist;
    //By playlistInputField = By.cssSelector("input[name='name']");
    @FindBy(css = "input[name='name']")
    WebElement playlistInputField;


    public HomePage( WebDriver givenDriver) {

        super(givenDriver);
    }

    public HomePage doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
        return this;
    }

    public HomePage enterPlaylistName(String playlistName){
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;

    }

    public boolean doesPlaylistExist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" +playlistName+"']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" +playlistName+ "']"));
        return playlistElement.isDisplayed();
    }
    public WebElement getUserAvatar () {
        //since userAvatarIcon is declared as a web element above (using @FindBy), we can use it directly, without findBy
        return userAvatarIcon;
    }

}
