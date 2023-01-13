import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Homework21 extends BaseTest {

    //renames playlist using Actions double click (Pre-requisite - create at least one playlist)
    @Test
    public void renamePlaylist() {
        login("test123@test.com", "te$t$tudent");
        choosePlaylist("HW");
        doubleClickChoosePlaylist("HW");
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist("HW21"));
    }

    public void choosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"))).click();
    }

    public void doubleClickChoosePlaylist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]")));
        Actions action = new Actions(driver);
        WebElement playlistElement = driver.findElement(By.xpath("//section[@id='playlists']//ul//li//a[contains(text(), '" + playlistName + "')]"));
        action.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("HW21");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + playlistName + "']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }
}
