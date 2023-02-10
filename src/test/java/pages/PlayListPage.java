package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayListPage extends BasePage{

    @FindBy(css = "div.alertify-logs.top.right")
    private WebElement playlistCreatedMessageLocator;
    private By byPlaylistCreatedMessageLocator= By.cssSelector("div.alertify-logs.top.right");

    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean isPlaylistCreatedMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPlaylistCreatedMessageLocator));
        return playlistCreatedMessageLocator.isDisplayed();
    }

}
