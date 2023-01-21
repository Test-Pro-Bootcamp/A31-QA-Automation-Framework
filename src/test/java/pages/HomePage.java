package pages;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.lang.String;
import java.util.List;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import static org.openqa.selenium.support.How.*;

public class HomePage extends BasePage {

    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(xpath = "//i[@data-testid='sidebar-create-playlist-btn']")
    WebElement addPlaylistBtn;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement simplePlaylist;
    @FindBy(xpath = "//input[@name='name']")
    WebElement playlistNameField;
//    By addPlaylistBtn = By.xpath("//i[@data-testid='sidebar-create-playlist-btn']");
//    By simplePlaylist = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
//    By playlistNameField = By.xpath("//input[@name='name']");

    public HomePage( WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return userAvatarIcon;
    }

    public void createPlaylist(String testPlaylist){
        //WebElement createPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
        //createPlaylistBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(addPlaylistBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(simplePlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(playlistNameField)).sendKeys(testPlaylist, Keys.ENTER);

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
        wait.until(ExpectedConditions.elementToBeClickable(playlistNameField)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(newName, Keys.ENTER);
    }

    public boolean doesPlaylistExist(String playlistName) {
//        HomePage homePage = new HomePage(driver);
//        return homePage.findElement(By.xpath("//a[contains(text(), '"+playlistName+"')]")).isDisplayed();
        int repeat = 0;
        while(repeat < 3){
            try{
                List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

                for (WebElement pl : playlistNames) {
                    String name = pl.getText();
                    if (name.equals(playlistName))
                        return true;
                }
            }catch (StaleElementReferenceException e){
                e.printStackTrace();
            }
            repeat++;
        }
        return false;
    }

    public void deletePlaylist(String playlistName){
        HomePage homePage = new HomePage(driver);
        homePage.contextClick(By.xpath("//a[contains(text(), '"+playlistName+"')]"));
        homePage.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//ul//li[contains(text(), 'Delete')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
    }

}
