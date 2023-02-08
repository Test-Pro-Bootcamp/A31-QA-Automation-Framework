package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(givenDriver,this);
    }

    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(xpath = "//i[@data-testid='sidebar-create-playlist-btn']")
    WebElement addPlaylistBtn;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement simplePlaylist;
    @FindBy(xpath = "//input[@name='name']")
    WebElement playlistNameField;
    @FindBy(css = "i[title='Create a new playlist']")
    WebElement createPlaylistBtn;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement newSimplePlaylistOptionBtn;
    @FindBy(css = "input[name='name']")
    WebElement newPlaylistInputField;


    public WebElement getUserAvatar () {

        return userAvatarIcon;
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    }
    public void conTextClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element= driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }
    public void newName() {
        WebElement inputNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        inputNewName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        String newPlayListName = "Tatsiana";
        inputNewName.sendKeys(newPlayListName);
        inputNewName.sendKeys(Keys.ENTER);
    }
    public boolean checkPlayList (){
        String newPlayListName = "Tatsiana";
        WebElement createdPlayList = driver.findElement(By.xpath("//a[text()='"+newPlayListName+"']"));
        return createdPlayList.isDisplayed();
    }
    public void createPlaylist(String playlistName) {
        click(createPlaylistBtn);
        click(newSimplePlaylistOptionBtn);
        checkElement(newPlaylistInputField).sendKeys(playlistName, Keys.ENTER);
    }
    public WebElement checkElement(WebElement element)
    {
        return  wait.until(ExpectedConditions.visibilityOf(element));
    }







    }


