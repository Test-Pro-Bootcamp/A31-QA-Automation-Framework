import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21_JRP extends BaseTest{
    @Test
    public void renamePlaylistTest() {
        String playlistName = "Homework21";
        String newPlaylistName = "JRP Playlist";

        //Login valid credentials
        login("jrpasia@gmail.com", "B3n@iah2013");

        //Click on "+" icon
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        //First create a playlist
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        //Right-click created playlist
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        Actions acts = new Actions(driver);
        acts.contextClick(createdPlaylist).perform();

        //Click "Edit" option
        WebElement editThePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='Edit']")));
        editThePlaylist.click();

        //Enter new playlist name
        WebElement newNameField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']"));
        newNameField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));

        //Assert through delete message box
        WebElement deleteMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        Assert.assertTrue(deleteMessageBox.isDisplayed());


    }

}
