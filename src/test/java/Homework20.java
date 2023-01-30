import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Homework20 extends BaseTest {
    @Test
    @Parameters("BaseURL")
    public void deletePlaylistTest(String BaseURL) throws InterruptedException {
        String playlistName="Crystal";
        login("demo@class.com", "te$t$tudent");
        WebDriver ExpectedConditions = null;
        WebDriver explicitWait = null;
        addPlaylist(playlistName);
        WebElement playlist= choosePlaylist(playlistName);
        deletePlaylist(playlist);
        validatePlaylistDeleted(playlistName);

    }

    public void addPlaylist(String newPlaylistName) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"))).click();

        WebElement playlistNameBox = wait.until(driver -> driver.findElement(By.xpath("//input[@name='name']")));

        playlistNameBox.sendKeys(newPlaylistName);
        playlistNameBox.submit();

    }

    public WebElement choosePlaylist(String playlistName) {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+playlistName+"']")));
        return playlist;

    }

    public void deletePlaylist(WebElement playlistToDelete) {
        Actions actions = new Actions(driver);
        actions.contextClick(playlistToDelete).perform();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@data-testid,'playlist-context-menu-delete')]")));
        deleteButton.click();
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify-logs top right']")));

    }

    public void validatePlaylistDeleted(String playlistNameToCheck) {
        List< WebElement> playlist = (List<WebElement>) driver.findElements((By.xpath("//a[@text()='"+playlistNameToCheck+"']")));
        Assert.assertEquals(playlist.size(),0);
    }

}

