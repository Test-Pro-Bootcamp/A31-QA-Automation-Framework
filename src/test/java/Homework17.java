import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");

        WebElement addPlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fa-plus-circle")));
        addPlaylistButton.click();

        WebElement newPlaylistButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistButton.click();

        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form>input[name='name']")));
        playlistNameField.click();
        playlistNameField.sendKeys("New Playlist");
        playlistNameField.sendKeys(ENTER);

        WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li>a.home")));
        homeButton.click();

        Actions action = new Actions(driver);
        WebElement rightClickSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Mid-Air Machine')]")));
        action.contextClick(rightClickSong).perform();

        WebElement clickAddTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Add To')]")));
        clickAddTo.click();

        WebElement clickPlaylist = driver.findElement(By.cssSelector("li.has-sub>ul>li.playlist"));
        clickPlaylist.click();

        closeBrowser();
    }

}
