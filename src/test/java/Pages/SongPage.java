package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

public class SongPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Dark Days')]")
    WebElement doubleClickSong;
    @FindBy(css = "div>img[alt='Sound bars']")
    WebElement visualizer;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement rightClickList;
    @FindBy(css = ".playlist-item-menu>ul>li:nth-child(2)")
    WebElement deletePlaylistClick;
    @FindBy(css = "button.ok")
    WebElement okButton;
    @FindBy(css = ".alertify-logs>.success")
    WebElement successDeleteMsg;

    public SongPage (WebDriver givenDriver){
        super(givenDriver);
    }

    public void playSong(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Dark Days')]")));
        actions.doubleClick(doubleClickSong).perform();
    }

    public void isSongPlaying(){
        Assert.assertTrue(visualizer.isDisplayed());
    }

    public void rightClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(rightClickList));
        Actions action = new Actions(driver);
        action.contextClick(rightClickList).perform();
    }

    public void deletePlaylist(){
        deletePlaylistClick.click();
        okButton.click();
    }

    public void verifyPlaylistIsDeleted(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs>.success")));
        Assert.assertTrue(successDeleteMsg.isDisplayed());
    }

    public void addPlaylistButton(){
        WebElement addPlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa-plus-circle")));
        addPlaylistButton.click();
    }

    public void newPlaylistButton(){
        WebElement newPlaylistButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButton.click();
    }

    public void selectPlaylistField(){
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form>input[name='name']")));
        playlistNameField.click();
        playlistNameField.sendKeys("New Playlist");
        playlistNameField.sendKeys(ENTER);
    }

    public void selectHomeButton(){
        WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li>a.home")));
        homeButton.click();

    }

    public void rightClickSong(){
        Actions action = new Actions(driver);
        WebElement rightClickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Mid-Air Machine')]")));
        action.contextClick(rightClickSong).perform();
    }

    public void addToPlaylist(){
        WebElement clickAddTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Add To')]")));
        clickAddTo.click();
    }

    public void clickPlaylist(){
        WebElement clickPlaylist = driver.findElement(By.cssSelector("li.has-sub>ul>li.playlist"));
        clickPlaylist.click();
    }

    public void clickEdit(){
        WebElement clickEdit = driver.findElement(By.xpath("//li[contains(text(), 'Edit')]"));
        clickEdit.click();
    }

    public void editField(){
        WebElement editField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys("Renamed Playlist Successful");
        editField.sendKeys(ENTER);
    }
}
