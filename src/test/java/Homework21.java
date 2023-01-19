import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends MyBaseTest{
    String playlistName = "My playlist";
    @Test
    public void renamePlaylist() {
        login("ghoulishgirl@hotmail.com", "te$t$tudent");
        pickPlaylist();
        contextClickPickPlaylist();
        enterPlaylistName();
        doesPlaylistExist();

    }
public void pickPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
}
public void contextClickPickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        action.doubleClick(playlistElement).perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[contains(text(), 'Edit')]"))).click();

}
public void enterPlaylistName(){
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a",Keys. BACK_SPACE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
public boolean doesPlaylistExist(){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+ playlistName+"']"));
        return playlistElement.isDisplayed();
}
}

