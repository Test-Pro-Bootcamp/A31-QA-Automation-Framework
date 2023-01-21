package pages;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;

public class HomePage extends BasePage {

    By userAvatarIcon = By.cssSelector("img.avatar");
    By addPlaylistBtn = By.xpath("//i[@data-testid='sidebar-create-playlist-btn']");
    By simplePlaylist = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
    By playlistNameField = By.xpath("//input[@name='name']");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }

    public void createTestPlaylist(String testPlaylist){
        //WebElement createPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
        //createPlaylistBtn.click();
        HomePage homePage = new HomePage(driver);
        homePage.click(addPlaylistBtn);
        homePage.click(simplePlaylist);
        homePage.findElement(playlistNameField).sendKeys(testPlaylist, Keys.ENTER);

        //playlistName.sendKeys(testPlaylist, Keys.ENTER);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"))).click();
        //WebElement playlistNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        //playlistNameField.click();
        //playlistNameField.sendKeys(testPlaylist, Keys.ENTER);
    }

    public WebElement selectPlaylist(String testPlaylist){
        HomePage homePage = new HomePage(driver);
        WebElement selectedPlaylist = homePage.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+testPlaylist+"')]"));
        return selectedPlaylist;
    }

    public void renamePlaylist(String playlistToRename, String newName) {
        HomePage homePage = new HomePage(driver);
        homePage.doubleClick(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+playlistToRename+"')]"));
        homePage.findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        homePage.findElement(playlistNameField).sendKeys(newName, Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName){
        HomePage homePage = new HomePage(driver);
        return homePage.findElement(By.xpath("//a[contains(text(), '"+playlistName+"')]")).isDisplayed();
    }

    public void deleteTestPlaylist(String playlistName){
        HomePage homePage = new HomePage(driver);
        homePage.contextClick(By.xpath("//a[contains(text(), '"+playlistName+"')]"));
        homePage.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//ul//li[contains(text(), 'Delete')]")).click();
    }

}
