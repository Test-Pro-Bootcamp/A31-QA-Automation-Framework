package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    By waitingOnATrainSongPlaylist = By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[@class='item-container']/table/tr/td[@class='title' and contains(text(),\"Waiting On A Train\")]");
    public PlaylistPage (WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement confirmXYZPlaylist () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(waitingOnATrainSongPlaylist));
    }

}
