package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    // Playlist Locators
    By createPlaylistBtn = By.cssSelector("i[title='Create a new playlist']");
    By newSimplePlaylistOptionBtn = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By newPlaylistInputField = By.cssSelector("input[name='name']");
    By editPlaylistOptionBtn = By.xpath("//li[contains(@data-testid,'playlist-context-menu-edit')]");
    By deletePlaylistBtn = By.cssSelector("button[title='Delete this playlist']");

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
        WebElement element = checkElement(By.xpath("//input[contains(@data-testid,'inline')]"));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE ));
        element.sendKeys(newName);
        element.sendKeys(Keys.ENTER);
    }

    public void  deletePlaylist(String playlistName)
    {
        click(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName)));      //Click on the playlist
        click(deletePlaylistBtn);       //Click the delete playlist button

        //Try to press the ok button, in the case of deleting a playlist that is not empty
        try {driver.findElement(By.cssSelector("button[class='ok']")).click();} catch (Exception e){}
    }

    public void clickTabInYourMusic(String tabName){
        click(By.cssSelector(String.format("a[href='#!/%s']", tabName)));
    }

    public void clickSidePanelPlaylist(String playlist)
    {
        click(By.xpath(String.format("//section[@id='playlists']/ul/li/a[contains(text(),'%s')]", playlist)));
    }

    public void playTheSong(String name)
    {
        clickTabInYourMusic("songs");
        doubleClick(By.xpath(String.format("//td[contains(text(), '%s')]", name)));
    }
}
