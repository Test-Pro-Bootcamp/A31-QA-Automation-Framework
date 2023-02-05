package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    //WebElements
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy (css = "i.fa.fa-plus-circle")
    private WebElement addPlaylistButton;

    @FindBy (xpath = "//li[text()='New Playlist']")
    private WebElement addNewPlaylistButton;
    ////*[@id="playlists"]/nav/ul/li[1] OR //li[text()='New Playlist']

    @FindBy (css = "input[type='text'][name='name']")
    private WebElement newPlaylistTextField;

    @FindBy(xpath = "//a[text()='XYZ Playlist']")
    private WebElement xyzPlaylist;

    @FindBy (xpath = "//*[@id=\"app\"]/nav/ul/li[4]")
    private WebElement addToButton;

    @FindBy (xpath = "//*[@id=\"app\"]/nav/ul/li/ul/li[contains(text(),\"XYZ Playlist\")]")
    private WebElement xyzPlaylistButton;

    @FindBy (xpath = "//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']")
    private WebElement xyzPlaylistDropDownClick;

    @FindBy (css = "img[alt='Sound bars']")
    private WebElement soundBarsShown;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addPlaylistButton));
        addPlaylistButton.click();
    }

    public void selectNewPlaylistFromDropdown() {
        addNewPlaylistButton.click();
    }

    public void createXYZPlaylist() {
        newPlaylistTextField.click();
        newPlaylistTextField.sendKeys("XYZ Playlist" + Keys.ENTER);
    }

    public WebElement confirmXYZPlaylist() {
        return wait.until(ExpectedConditions.visibilityOf(xyzPlaylist));
    }

    public void navigateToAllSongsPage () {
        String url2="https://bbb.testpro.io/#!/songs";
        driver.get(url2);
    }

    public void clickAddTooButton () {
        addToButton.click();
    }

    public void clickXYZInDropdown () {
        xyzPlaylistButton.click();
    }

    public void selectXYZPlaylist () {
        xyzPlaylistDropDownClick.click();
    }

    public WebElement soundBarsShownMethod () {
        return wait.until(ExpectedConditions.visibilityOf(soundBarsShown));
    }
}

