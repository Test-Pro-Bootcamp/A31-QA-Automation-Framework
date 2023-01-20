package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String playlistName = "my";
    String newPlaylistName = "lalala";
    By addNewPlaylist = By.xpath("//*[@title='Create a new playlist']");
    By newPlaylist = By.xpath("//li[text()='New Playlist']");
    By nameField = By.xpath("//input[@name='name']");
    By myPlaylist = By.xpath("//li/a[text()='" + playlistName + "']");
    By editButton = By.xpath("//li[text()='Edit']");
    By editField = By.xpath("//input[@name='name']");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void addNewPlaylistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewPlaylist));
        driver.findElement(addNewPlaylist).click();
    }
    public void newPlaylistButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
        driver.findElement(newPlaylist).click();
    }
    public void provideName() {
        WebElement enternameField = driver.findElement(nameField);
        enternameField.sendKeys(playlistName);
        enternameField.sendKeys(Keys.ENTER);
    }
    public void editButtonClick() {
        WebElement playlist = driver.findElement(myPlaylist);
        Actions showEditButton = new Actions(driver);
        showEditButton.contextClick(playlist).perform();
    }
    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        driver.findElement(editButton).click();
    }
    public void rename() {
        WebElement renameField = wait.until(ExpectedConditions.elementToBeClickable(editField));
        renameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        renameField.sendKeys(newPlaylistName, Keys.ENTER);
    }
    public void checkRename() {
        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));
        for (WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals(newPlaylistName)) {
                Assert.assertTrue(true);
            }
        }
    }
}


