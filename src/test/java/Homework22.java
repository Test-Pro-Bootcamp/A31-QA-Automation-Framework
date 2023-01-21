import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class Homework22 extends BaseTest{

    @Test (enabled = true, priority = 1, description = "refactor using pom")
    @Parameters({"TestPlaylist", "NewName"})
    public void renamePlaylistValidName(String testPlaylist, String newName){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn();

        HomePage homePage = new HomePage(driver);
        homePage.createTestPlaylist(testPlaylist);
        //rename playlist
        homePage.renamePlaylist(testPlaylist, newName);

        //assertion
        Assert.assertTrue(homePage.doesPlaylistExist(newName));

        //clean up after test
        homePage.deleteTestPlaylist(newName);
    }

//    public void createTestPlaylist(String testPlaylist){
//        //WebElement createPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='sidebar-create-playlist-btn']")));
//        //createPlaylistBtn.click();
//        HomePage homePage = new HomePage(driver);
//        homePage.getAddPlaylistBtn().click();
//
//        homePage.click("//li[@data-testid='playlist-context-menu-create-simple']"));
//
//        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"))).click();
//
//        WebElement playlistNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
//        playlistNameField.click();
//        playlistNameField.sendKeys(testPlaylist, Keys.ENTER);
//    }

//    public WebElement selectPlaylist(String testPlaylist){
//        WebElement selectedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+testPlaylist+"')]")));
//        return selectedPlaylist;
//    }

//    public void enterNewName(WebElement playlistToRename, String newName) {
//        Actions action = new Actions(driver);
//        action.doubleClick(playlistToRename).perform();
//
//        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
//        nameField.click();
//        nameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
//        nameField.sendKeys(newName, Keys.ENTER);
//    }

//    public boolean doesPlaylistExist(String playlistName){
//        WebElement renamedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '"+playlistName+"')]")));
//        return renamedPlaylist.isDisplayed();
//    }

//    public void deleteTestPlaylist(String playlistName){
//        WebElement playlistToDelete = driver.findElement(By.xpath("//a[contains(text(), '"+playlistName+"')]"));
//        Actions action = new Actions(driver);
//        action.contextClick(playlistToDelete).perform();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='menu playlist-item-menu']//ul//li[contains(text(), 'Delete')]"))).click();
//    }
}