package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllSongsPage extends BasePage {

    static WebDriver driver;
    WebDriverWait wait;
    static Actions actions;

    static By waitingOnATrainSong = By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void rightClickSong() {
        WebElement waitingOnATrainSongClick = driver.findElement(waitingOnATrainSong);
        actions.contextClick(waitingOnATrainSongClick);
    }

}
