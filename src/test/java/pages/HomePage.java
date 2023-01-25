package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends pages.BasePage {
    String playlistName = "Homework";
    //Locators
    @FindBy(css = "[class='home active']")
    private WebElement homeButton;
    @FindBy(css = "[class='queue']")
    private WebElement currentQue;
    @FindBy(css = "[class='songs']")
    private WebElement allSongsButton;
    @FindBy(css = "[alt='Sound bars']")
    private WebElement soundBars;
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By createdPlaylist = By.xpath("//li/a[text()='"+playlistName+"']");


    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }
    public WebElement getCreatedPlaylist () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createdPlaylist));
    }
    public HomePage clickHomeButton() {
        homeButton.click();
        return this;
    }
    public HomePage clickCurrentQueBtn() {
        currentQue.click();
        return this;
    }
    public HomePage clickAllSongsBtn() {
        allSongsButton.click();
        return this;
    }
    public HomePage inputPlaylistName() throws InterruptedException {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        Thread.sleep(1000);
        return this;
    }
    public HomePage assertSoundBars() {
        soundBars.isDisplayed();
        return this;
    }

}
