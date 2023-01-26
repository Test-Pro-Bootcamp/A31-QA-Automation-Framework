package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
        PageFactory.initElements(givenDriver, this);
    }

    // Playlist Locators
    @FindBy(css = "i[title='Create a new playlist']") WebElement createPlaylistBtn;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']") WebElement newSimplePlaylistOptionBtn;
    @FindBy(css = "input[name='name']") WebElement newPlaylistInputField;
    @FindBy(xpath = "//li[contains(@data-testid,'playlist-context-menu-edit')]") WebElement editPlaylistOptionBtn;
    @FindBy(css = "button[title='Delete this playlist']") WebElement deletePlaylistBtn;
    @FindBy(css = "a[href='#!/songs']") WebElement allSongsTab;


    public void createPlaylist(String playlistName)
    {
        click(createPlaylistBtn);           //Click create new playlist button
        click(newSimplePlaylistOptionBtn);        //Click simple playlist option
        checkElement(newPlaylistInputField).sendKeys(playlistName, Keys.ENTER);
    }

    public void renamePlaylist(String playlistName, String newName)
    {
        rightClick(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName)));        //context click the playlist
        click(editPlaylistOptionBtn);        //click edit option
        WebElement element = checkElement(driver.findElement(By.xpath("//input[contains(@data-testid,'inline')]")));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE ));
        element.sendKeys(newName);
        element.sendKeys(Keys.ENTER);
    }

    public void  deletePlaylist(String playlistName)
    {
        click(findElement(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName))));
        click(deletePlaylistBtn);       //Click the delete playlist button

        //Try to press the ok button, in the case of deleting a playlist that is not empty
        try {driver.findElement(By.cssSelector("button[class='ok']")).click();} catch (Exception e){}
    }

    public void clickFromYourMusicPanel(String tabName)
    {
        click(findElement(By.cssSelector(String.format("a[href='#!/%s']", tabName))));
    }

    public void clickSidePanelPlaylist(String playlist)
    {
        click(findElement(By.xpath(String.format("//section[@id='playlists']/ul/li/a[contains(text(),'%s')]", playlist))));
    }

    public void playTheSong(String name)
    {
        clickFromYourMusicPanel("songs");
        doubleClick(By.xpath(String.format("//td[contains(text(), '%s')]", name)));
    }
}
