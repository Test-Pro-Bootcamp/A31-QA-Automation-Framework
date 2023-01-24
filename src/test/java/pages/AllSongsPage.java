package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllSongsPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By waitingOnATrainSong = By.xpath("//*[text()='HoliznaCC0 - Waiting On A Train']");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void rightClickSong() {
        WebElement waitingOnATrainSongClick = driver.findElement(waitingOnATrainSong);
        actions.contextClick(waitingOnATrainSongClick).perform();
    }

}
