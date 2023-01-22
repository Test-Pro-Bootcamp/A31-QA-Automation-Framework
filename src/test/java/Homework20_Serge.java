import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20_Serge extends BaseTest{

    String newPlaylistName = "Serge Playlist 3";

    @Test
    public void renamePlaylist()   {
        login("serge.uwiduhaye@gmail.com", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }

    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+newPlaylistName+"']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+newPlaylistName+"']"));
        return playlistElement.isDisplayed();
    }







}
