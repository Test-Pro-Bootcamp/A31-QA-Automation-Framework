import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylistTest() {
        String playlistName = "Homework20";

        //Login valid credentials
        login("jrpasia@gmail.com", "B3n@iah2013");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        //First create a playlist
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName,Keys.ENTER);

        //Right-click created playlist
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        Actions acts = new Actions(driver);
        acts.contextClick(createdPlaylist).perform();

        //Click "Delete" option
        WebElement deleteThePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='Delete']")));
        deleteThePlaylist.click();

        //Assert through delete message box
        WebElement deleteMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        Assert.assertTrue(deleteMessageBox.isDisplayed());


    }
}
