package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllSongsPage extends BasePage {

    //locators
    @FindBy(xpath = "//*[text()='HoliznaCC0 - Waiting On A Train']")
    private WebElement waitingOnATrainSong;

    @FindBy(xpath = "//*[@id='songsWrapper']/div/div/div[1]/table/tr[1]/td[2]")
    private WebElement songOnAllSongsPage;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void rightClickSong() {
        Actions rightClick = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(waitingOnATrainSong));
        rightClick.contextClick(waitingOnATrainSong).perform();
    }

    public void doubleClickSong() {
        Actions doubleClick = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(songOnAllSongsPage));
        doubleClick.doubleClick(songOnAllSongsPage).perform();
    }
}
