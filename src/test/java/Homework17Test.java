import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homework17Test extends BaseTest {

    public boolean isNotificationPopUpPresent(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }


    @Test(description = "Move a Song to a Play List")
    public void addASong() throws InterruptedException {
        grabUrl();
        logIn("skyeman75@gmail.com","te$t$tudent");
        driver.manage().window().maximize();
        searchSong("Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Test Pro Playlist");
        Assert.assertTrue(isNotificationPopUpPresent());
    }

    public void searchSong(String songTitleKeyword)throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }
    public void viewAllSearchResults()throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }
    public void selectFirstSongResult()throws InterruptedException {
        WebElement viewAllFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        viewAllFirstSongResult.click();
        Thread.sleep(2000);
    }
    public void clickAddToButton()throws InterruptedException{
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist(String playlistName)throws InterruptedException{
        WebElement playListNameElement  = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'"+playlistName+"')]"));
        playListNameElement.click();
        Thread.sleep(2000);
    }
}

