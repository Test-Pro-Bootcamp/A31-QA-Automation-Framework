package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By addToBtn = By.xpath("//button[@class='btn-add-to']");

    public void addSongInPlaylist(String song, String playlist)
    {
        HomePage homePage = new HomePage(driver);
        click(By.xpath(String.format("//td[contains(text(),'%s')]", song)));        //Select a song to be inserted
        click(addToBtn);        //Click the add to button
        click(By.xpath(String.format("//section[@id='songsWrapper']/header/div/div/section/ul/li[contains(text(),'%s')]" ,playlist)));              //Choose the created playlist, to add the song to that playlist
        homePage.clickSidePanelPlaylist(playlist);      // click on side panel playlist tab
    }
}
