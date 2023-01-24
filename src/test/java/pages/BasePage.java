package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClick(By locator) {
        actions.contextClick(findElement(locator)).perform();
    }
    public void doubleClick (By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }
    public void assertAddDeleteMessage() {
        WebElement addDeleteMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        Assert.assertTrue(addDeleteMessageBox.isDisplayed());
    }
    public void clickPlusIcon() {
        WebElement plusIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Create a new playlist']")));
        plusIcon.click();
    }
    public void clickNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='New Playlist']")));
        newPlaylist.click();
    }

}