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

    WebDriver driver;
    WebDriverWait wait;

    //WebElements
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
//    By userAvatarIcon = By.cssSelector("img.avatar");

    @FindBy (css = "i.fa.fa-plus-circle")
    WebElement addPlaylistButton;
//    By addPlaylistButton = By.cssSelector("i.fa.fa-plus-circle");

    @FindBy (xpath = "//li[text()='New Playlist']")
    WebElement addNewPlaylistButton;
//    By addNewPlaylistButton = By.xpath("//li[text()='New Playlist']");

    @FindBy (css = "input[type='text'][name='name']")
    WebElement newPlaylistTextField;
//    By newPlaylistTextField = By.cssSelector("input[type='text'][name='name']");

    @FindBy(xpath = "//a[text()='XYZ Playlist']")
    WebElement xyzPlaylist;
//    By xyzPlaylist = By.xpath("//a[text()='XYZ Playlist']");

    @FindBy (xpath = "//*[@id=\"app\"]/nav/ul/li[4]")
    WebElement addToButton;
//    By addToButton = By.xpath("//*[@id=\"app\"]/nav/ul/li[4]");

    @FindBy (xpath = "//*[@id=\"app\"]/nav/ul/li/ul/li[contains(text(),\"XYZ Playlist\")]")
    WebElement xyzPlaylistButton;
//    By xyzPlaylistButton = By.xpath("//*[@id=\"app\"]/nav/ul/li/ul/li[contains(text(),\"XYZ Playlist\")]");

    @FindBy (xpath = "//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']")
    WebElement xyzPlaylistDropDownClick;
//    By xyzPlaylistDropDownClick = By.xpath("//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']");


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
//        driver.findElement(addPlaylistButton).click();
    }

    public void selectNewPlaylistFromDropdown() {
        addNewPlaylistButton.click();
//        driver.findElement(addNewPlaylistButton).click();
    }

    public void createXYZPlaylist() {
        newPlaylistTextField.click();
        newPlaylistTextField.sendKeys("XYZ Playlist" + Keys.ENTER);
//        driver.findElement(newPlaylistTextField).click();
//        driver.findElement(newPlaylistTextField).sendKeys("XYZ Playlist" + Keys.ENTER);
    }

    public WebElement confirmXYZPlaylist() {
        return wait.until(ExpectedConditions.visibilityOf(xyzPlaylist));
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(xyzPlaylist));
    }

    public void navigateToAllSongsPage () {
        String url2="https://bbb.testpro.io/#!/songs";
        driver.get(url2);
    }

    public void clickAddTooButton () {
        addToButton.click();
//        WebElement addToButtonElement = driver.findElement(addToButton);
//        addToButtonElement.click();
    }

    public void clickXYZInDropdown () {
        xyzPlaylistButton.click();
//        WebElement xyzPlaylistDropdownElement = driver.findElement(xyzPlaylistButton);
//        xyzPlaylistDropdownElement.click();
    }

    public void selectXYZPlaylist () {
        xyzPlaylistDropDownClick.click();
//        WebElement xyzPlaylistDropdownLinkElement = driver.findElement(xyzPlaylistDropDownClick);
//        xyzPlaylistDropdownLinkElement.click();
    }
}

