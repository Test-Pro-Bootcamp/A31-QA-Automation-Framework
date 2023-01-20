package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    @FindBy(css = "a[class='songs']")
    WebElement allSongsLocator;
    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")
    WebElement songNameLocator;
    @FindBy(xpath = "//i[@data-testid='play-next-btn']")
    WebElement playNextButtonLocator;
    @FindBy(xpath = "//span[@data-testid='play-btn']")
    WebElement playButtonLocator;
    @FindBy(css = "img[alt='Sound bars']")
    WebElement soundBarsLocator;

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void allSongs() {
        allSongsLocator.click();
    }
    public void songName() {
        songNameLocator.click();
    }
    public void playNextButton() {
        playNextButtonLocator.click();
    }
    public void playButton() {
        playButtonLocator.click();
    }
    public boolean soundBars() {
        WebElement usersAvatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        return usersAvatar.isDisplayed();
    }
}