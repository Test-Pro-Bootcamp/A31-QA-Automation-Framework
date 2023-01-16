import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Homework21 extends BaseTest{
    String playlistname = "L21Rename";
    @Test
    public void renamePlaylist(){
        login("dummytest@class.com","te$t$tudent");
        choosePlaylist();
        contextClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()='L21']"))).click();
    }
    public void contextClickChoosePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }
    public void enterPlaylistName() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistInputField.sendKeys(playlistname);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+playlistname+"']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistname+"']"));
        return playlistElement.isDisplayed();
    }



}
