import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTest extends BaseTest{

    @Test(enabled = true)
    public void addSongTest() throws InterruptedException {
        String playlistName = "Homework";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        Actions acts = new Actions(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click on "+" icon to create a playlist
        basePage.findElement(By.xpath("//i[@title='Create a new playlist']")).click();

        //Click "New Playlist"
        basePage.findElement(By.xpath("//li[text()='New Playlist']")).click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        Thread.sleep(3000);

        //Click "All Songs"
        basePage.findElement(By.xpath("//li/a[text()='All Songs']")).click();

//        //Click "Add To" button
//        WebElement addToBtn = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/span/button[2]"));
//        addToBtn.click();


        //Click "Reactor" song
        WebElement reactorSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[12]/td[2]"));
        reactorSong.click();

        //Click green "Add To" button
        loginPage.findElement(By.cssSelector("button[class='btn-add-to']"));

        //Click "Homework" Playlist
        WebElement createdPlaylist = driver.findElement(By.xpath("//*[@id='songsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));
        createdPlaylist.click();

        //Validate "Reactor" song is added
//        Thread.sleep(3000);
//        WebElement morningJamPlaylist = driver.findElement(By.cssSelector("[href='#!/playlist/18754']"));
//        morningJamPlaylist.click();
//        WebElement reactorSongIsPresent = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[13]/td[2]"));
//        Assert.assertTrue(reactorSongIsPresent.isDisplayed());
//        driver.quit();
    }

    @Test(enabled = false)
    public void renamePlaylistTest() {
        String playlistName = "Homework";
        String newPlaylistName = "JRP Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        Actions acts = new Actions(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click on "+" icon to create a playlist
        basePage.findElement(By.xpath("//i[@title='Create a new playlist']")).click();

        //Click "New Playlist"
        basePage.findElement(By.xpath("//li[text()='New Playlist']")).click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        //Right-click created playlist
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        acts.contextClick(createdPlaylist).perform();

        //Click "Edit" option
        basePage.findElement(By.xpath("//ul/li[text()='Edit']")).click();

        //Enter rename playlist
        WebElement newNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[5]")));
        acts.doubleClick(newNameField).build().perform();
//        newNameField.clear();
//        newNameField.sendKeys(newPlaylistName, Keys.ENTER);


    }
    @Test(enabled = false)
    public void deletePlaylistTest() {
        String playlistName = "Homework";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click on "+" icon to create new playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        //Click "New Playlist"
        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName,Keys.ENTER);

        //Right-click created playlist
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        Actions acts = new Actions(driver);
        acts.contextClick(createdPlaylist).perform();

        //Click "Delete" option
        WebElement deleteThePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[text()='Delete']")));
        deleteThePlaylist.click();

        //Assert through delete message box
        WebElement deleteMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        Assert.assertTrue(deleteMessageBox.isDisplayed());


    }
}
