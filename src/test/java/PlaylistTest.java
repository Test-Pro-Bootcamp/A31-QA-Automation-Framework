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
        basePage.clickPlusIcon();

        //Click "New Playlist"
        basePage.clickNewPlaylist();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        Thread.sleep(2000);

        //Click "All Songs"
        basePage.findElement(By.xpath("//li/a[text()='All Songs']")).click();

        //Click "Reactor" song
        WebElement reactorSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[12]/td[2]"));
        reactorSong.click();

        //Right-click song
        acts.contextClick(reactorSong).perform();

        //Click "Add To"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']")).click();

        //Click "Homework"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']/ul/li[7]")).click();

        //Validate "Reactor" song is added
        basePage.assertAddDeleteMessage();
//        WebElement addedMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
//        Assert.assertTrue(addedMessageBox.isDisplayed());

    }
    @Test(enabled = true)
    public void playPlaylistSongTest() throws InterruptedException {
        String playlistName = "Homework";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        Actions acts = new Actions(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click on "+" icon to create a playlist
        basePage.clickPlusIcon();
//        basePage.findElement(By.xpath("//i[@title='Create a new playlist']")).click();

        //Click "New Playlist"
        basePage.clickNewPlaylist();
//        basePage.findElement(By.xpath("//li[text()='New Playlist']")).click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);
        Thread.sleep(2000);

        //Click "All Songs"
        basePage.findElement(By.xpath("//li/a[text()='All Songs']")).click();

        //Click "Reactor" song
        WebElement reactorSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[12]/td[2]"));
        reactorSong.click();

        //Right-click song
        acts.contextClick(reactorSong).perform();

        //Click "Add To"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']")).click();

        //Click "Homework"
        basePage.findElement(By.xpath("//ul/li[@class='has-sub']/ul/li[7]")).click();

        //Validate "Reactor" song is added
        WebElement addedMessageBox = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        Assert.assertTrue(addedMessageBox.isDisplayed());

        //Go to created playlist
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        createdPlaylist.click();

        //Right-click song on list
        WebElement clickSongOnList = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]"));
        acts.contextClick(clickSongOnList).perform();

        //Click "Play" option
        WebElement playBtn = driver.findElement(By.xpath("//ul/li[@class='playback']"));
        playBtn.click();

        //Verify through displayed equalizer
        WebElement equalizerBars = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(equalizerBars.isDisplayed());

    }
    @Test(enabled = true)
    public void renamePlaylistTest() throws InterruptedException {
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
        basePage.clickPlusIcon();
//        basePage.findElement(By.xpath("//i[@title='Create a new playlist']")).click();

        //Click "New Playlist"
        basePage.clickNewPlaylist();
//        basePage.findElement(By.xpath("//li[text()='New Playlist']")).click();

        //Input playlist name
        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        //Double-click created playlist to edit
        WebElement createdPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        acts.doubleClick(createdPlaylist).perform();
        Thread.sleep(1000);

        //Double-click to highlight and rename
        WebElement highlightedList = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        acts.doubleClick(highlightedList).perform();
//        Thread.sleep(1000);
//        highlightedList.sendKeys(Keys.BACK_SPACE);
//        highlightedList.sendKeys(newPlaylistName, Keys.ENTER);

    }
    @Test(enabled = true)
    public void deletePlaylistTest() {
        String playlistName = "Test Delete";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);

        //Login valid credentials
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        //Click on "+" icon to create new playlist
        basePage.clickPlusIcon();

        //Click "New Playlist"
        basePage.clickNewPlaylist();

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
        basePage.assertAddDeleteMessage();



    }
}
