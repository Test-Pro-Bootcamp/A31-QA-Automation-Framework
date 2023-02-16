package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

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
//        okButton.click();
    }

    public void verifyPlaylistIsDeleted(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs>.success")));
        Assert.assertTrue(successDeleteMsg.isDisplayed());
    }

}
