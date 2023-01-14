import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17Test extends BaseTest {

    public boolean isNotificationPopUpPresent(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }


    @Test(description = "Move a Song to a Play List")
    public void addASong(){
        logIn("skyeman75@gmail.com","te$t$tudent");
        driver.manage().window().maximize();
        searchSong("Pluto");
        viewAllSearchResults();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Test Pro Playlist");
        Assert.assertTrue(isNotificationPopUpPresent());
    }

    public void searchSong(String songTitleKeyword){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#searchForm input[type='search']"))).click();
    }
    public void viewAllSearchResults(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button"))).click();
    }
    public void selectFirstSongResult(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title"))).click();
    }
    public void clickAddToButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-add-to"))).click();
    }
    public void choosePlaylist(String playlistName){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text(),'"+playlistName+"')]"))).click();
    }
}
