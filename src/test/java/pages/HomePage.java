package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;


public class HomePage extends BasePage {
    String playlistName = "my";
    String newPlaylistName = "lalala";
    @FindBy(xpath = "//*[@title='Create a new playlist']")
    WebElement addNewPlaylist;
    @FindBy(xpath = "//*[text()='New Playlist']")
    WebElement newPlaylist;
    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;
    @FindBy(xpath = "//li/a[text()='my']")
    WebElement myPlaylist;
    @FindBy(xpath = "//li[text()='Edit']")
    WebElement editButton;
    @FindBy(xpath = "//input[@name='name']")
    WebElement editField;
    public HomePage(WebDriver givenDriver) {super(givenDriver);
    }
    public void addNewPlaylistButton() {wait.until(ExpectedConditions.elementToBeClickable(addNewPlaylist)).click();
    }
    public void newPlaylistButton() {wait.until(ExpectedConditions.elementToBeClickable(newPlaylist)).click();
    }
    public void provideName() {wait.until(ExpectedConditions.elementToBeClickable(nameField));
        nameField.sendKeys(playlistName);
        nameField.sendKeys(Keys.ENTER);
    }
    public void editButtonClick() {wait.until(ExpectedConditions.elementToBeClickable(myPlaylist));
        Actions showEditButton = new Actions(driver);
        showEditButton.contextClick(myPlaylist).perform();
    }
    public void clickEdit() {wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }
    public void rename() {wait.until(ExpectedConditions.elementToBeClickable(editField));
        editField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(newPlaylistName, Keys.ENTER);
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