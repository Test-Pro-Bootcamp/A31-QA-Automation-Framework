package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SongPage extends BasePage {

    public SongPage (WebDriver givenDriver){
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public void playSong(){
        Actions actions = new Actions(driver);
        WebElement doubleClickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Dark Days')]")));
        actions.doubleClick(doubleClickSong).perform();
    }

    public void isSongPlaying(){
        WebElement visualizer = driver.findElement(By.cssSelector("div>img[alt='Sound bars']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }

    public void rightClickPlaylist(){
        WebElement rightClickList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        Actions action = new Actions(driver);
        action.contextClick(rightClickList).perform();
    }

    public void deletePlaylist(){
        WebElement deletePlaylistClick = driver.findElement(By.cssSelector(".playlist-item-menu>ul>li:nth-child(2)"));
        deletePlaylistClick.click();
    }

    public void verifyPlaylistIsDeleted(){
        WebElement successDeleteMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alertify-logs>.success")));
        Assert.assertTrue(successDeleteMsg.isDisplayed());
    }

}
