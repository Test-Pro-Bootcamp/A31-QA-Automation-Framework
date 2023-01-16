import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest {



    String playlistnewname = "Jarrod Playlist";

    @Test
    public void renamePlaylist() {
        logIn("skyeman75@gmail.com", "te$t$tudent");
        verifyLogIn();
        contextClickSelectPlaylist();
        contextClickEdit();
        Assert.assertTrue(checkPlaylistRenamed().isDisplayed());
    }

    public void contextClickSelectPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)"))).click();
        WebElement playListName = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.contextClick(playListName).perform();
    }

    public void contextClickEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit'"))).click();
        WebElement editField = driver.findElement(By.cssSelector("input{name='name']"));
        editField.sendKeys(playlistnewname);
        editField.sendKeys(Keys.ENTER);
    }

    public WebElement checkPlaylistRenamed() {

        return driver.findElement(By.cssSelector("div.success.show"));
    }
}


