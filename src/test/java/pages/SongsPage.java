package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class SongsPage extends BasePage{

    @FindBy(css = "section#songsWrapper button[title='Play all songs']")
    public WebElement playAllBtn;

    By playAllBtnLoc = By.cssSelector("section#songsWrapper button[title='Play all songs']");

    public SongsPage(WebDriver givenDriver){
        super(givenDriver);
    }


    public void playRandomSong(){
        WebElement songsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.items")));
        List<WebElement> songs = songsContainer.findElements(By.cssSelector("td.title"));

        Random rand = new Random();
        int songIndex = rand.nextInt(songs.size());

        acts.doubleClick(songs.get(songIndex)).perform();
    }


}
