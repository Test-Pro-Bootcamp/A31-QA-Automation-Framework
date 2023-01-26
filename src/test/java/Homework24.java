import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.LoginPage;

public class Homework24 extends BaseTest{
    @Test(enabled= true, priority = 1, description="create a new playlist")
    @Parameters({"TestPlaylist1"})
    public void createNewPlaylistValidNameTest(String testPlaylist){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn();

        HomePage homePage = new HomePage(getDriver());
        homePage.createPlaylist(testPlaylist);

        Assert.assertTrue(homePage.doesPlaylistExist(testPlaylist));

        homePage.deletePlaylist(testPlaylist);
    }

    @Test (enabled = true, priority = 2, description = "refactor using pom")
    @Parameters({"TestPlaylist2", "NewName"})
    public void renamePlaylistValidNameTest(String testPlaylist, String newName){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn();

        HomePage homePage = new HomePage(getDriver());
        homePage.createPlaylist(testPlaylist);
        //rename playlist
        homePage.renamePlaylist(testPlaylist, newName);

        //assertion
        Assert.assertTrue(homePage.doesPlaylistExist(newName));

        //clean up after test
        homePage.deletePlaylist(newName);
        //Assert.assertFalse(homePage.doesPlaylistExist(newName));
    }

    @Test(enabled = true, priority = 3, description = "delete an existing playlist test")
    @Parameters({"TestPlaylist3"})
    public void deleteExistingPlaylistTest(String testPlaylist){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn();

        HomePage homePage = new HomePage(getDriver());
        homePage.createPlaylist(testPlaylist);
        Assert.assertTrue(homePage.doesPlaylistExist(testPlaylist));

        homePage.deletePlaylist(testPlaylist);
        Assert.assertFalse(homePage.doesPlaylistExist(testPlaylist));
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