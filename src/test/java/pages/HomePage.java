package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css ="a.songs" )
    private WebElement allSongTabLocator;


    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean avatarIconDisplaying () {
        return userAvatarIcon.isDisplayed();
    }
    public void clickAllSongsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongTabLocator)).click();
    }
}
