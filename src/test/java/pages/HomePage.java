package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    By userAvatarIcon = By.cssSelector("img.avatar");
    By addPlaylistButton = By.cssSelector("i.fa.fa-plus-circle");
    By addNewPlaylistButton = By.xpath("//li[text()='New Playlist']");
    By newPlaylistTextField = By.cssSelector("input[type='text'][name='name']");
    By xyzPlaylist = By.xpath("//a[text()='XYZ Playlist']");
    By addToButton = By.xpath("//*[@id=\"app\"]/nav/ul/li[4]");
    By xyzPlaylistButton = By.xpath("//*[@id=\"app\"]/nav/ul/li/ul/li[contains(text(),\"XYZ Playlist\")]");
    By xyzPlaylistDropDownClick = By.xpath("//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addPlaylistButton));
        driver.findElement(addPlaylistButton).click();
    }

    public void selectNewPlaylistFromDropdown() {
        driver.findElement(addNewPlaylistButton).click();
    }

    public void createXYZPlaylist() {
        driver.findElement(newPlaylistTextField).click();
        driver.findElement(newPlaylistTextField).sendKeys("XYZ Playlist" + Keys.ENTER);
    }

    public WebElement confirmXYZPlaylist() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xyzPlaylist));
    }

    public void navigateToAllSongsPage () {
        String url2="https://bbb.testpro.io/#!/songs";
        driver.get(url2);
    }

    public void clickAddTooButton () {
        WebElement addToButtonElement = driver.findElement(addToButton);
        addToButtonElement.click();
    }

    public void clickXYZInDropdown () {
        WebElement xyzPlaylistDropdownElement = driver.findElement(xyzPlaylistButton);
        xyzPlaylistDropdownElement.click();
    }

    public void selectXYZPlaylist () {
        WebElement xyzPlaylistDropdownLinkElement = driver.findElement(xyzPlaylistDropDownClick);
        xyzPlaylistDropdownLinkElement.click();
//            WebElement xyzPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li/a[text()='XYZ Playlist']"));
//            xyzPlaylist.click();
    }
}

