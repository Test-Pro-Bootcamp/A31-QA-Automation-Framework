package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    //Attributes
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public String playlistName = null;
    
    //Web Element
    @FindBy (xpath="//a[contains(text(), 'All Songs')]")
    WebElement allSongsButton;
    @FindBy (css=".playlist:nth-child(3)")
    WebElement firstPlaylist;

    //locator
    By successMsg = By.cssSelector("div.success.show");

    //constructor
    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    //page methods
    public void waitClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void doubleClick(WebElement locator) {
        waitClick(locator);
        actions.doubleClick(locator).perform();
    }

    public WebElement getSuccessMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
    }

    public void clickAllSongs() {
        waitClick(allSongsButton);
        allSongsButton.click();
    }

    public void clickFirstPlaylist() {
        waitClick(firstPlaylist);
        firstPlaylist.click();
    }
}
