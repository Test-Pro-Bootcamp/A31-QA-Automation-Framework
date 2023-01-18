package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    By allSongsLocator = By.cssSelector("a[class='songs']");

    By songNameLocator = By.cssSelector("#songsWrapper > div > div > div.item-container > table > tr:nth-child(1) > td.title");

    By playNextButtonLocator = By.xpath("//i[@data-testid='play-next-btn']");

    By playButtonLocator = By.xpath("//span[@data-testid='play-btn']");

    By soundBarsLocator = By.cssSelector("img[alt='Sound bars']");

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void allSongs(){ driver.findElement(allSongsLocator).click();}

    public void songName(){ driver.findElement(songNameLocator).click();}

    public void playNextButton(){ driver.findElement(playNextButtonLocator).click();}

    public void playButton(){ driver.findElement(playButtonLocator).click();}

    public boolean soundBars(){
        WebElement userAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        return userAvatar.isDisplayed();
    }
}
