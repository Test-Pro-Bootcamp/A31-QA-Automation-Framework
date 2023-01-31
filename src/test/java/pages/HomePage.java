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
     By myPlaylist = By.xpath("//li/a[text()='my']");
    By deleteButton = By.xpath("//*[@title='Delete this playlist']");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage enterPlayList () {wait.until(ExpectedConditions.elementToBeClickable(myPlaylist)).click();
        return this;       }
    public HomePage clickDelete() {wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        return this; }
    }