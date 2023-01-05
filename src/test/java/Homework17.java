import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test (enabled = true, priority = 0)
    public static void launchKoelTest () {

        //Navigate to testpro
        navigateToTestPro();

        //Confirm successful navigation
        WebElement koelLogo = driver.findElement(By.cssSelector("img[alt]"));

    }

    @Test (enabled = true, priority = 1)
    public static void loginValidUserNameTest () {

        navigateToTestPro();

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //Confirm successful login
        WebElement usersAvatar = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(usersAvatar.isDisplayed());

    }

    @Test (enabled = true, priority = 2)
    public static void createPlaylistTest () {

        //CREATE PLAYLIST TEST
        //open Koel
        navigateToTestPro();

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //click add button
        WebElement createPlaylist = driver.findElement(By.cssSelector("i.fa.fa-plus-circle.create"));
        createPlaylist.click();

        //select New Playlist from dropdown
        WebElement NewPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        NewPlaylist.click();

        WebElement playlistTextField = driver.findElement(By.cssSelector("input[type='text'][name='name']"));
        playlistTextField.click();
        playlistTextField.sendKeys("XYZ Playlist" + Keys.ENTER);

        //confirm playlist creation
        WebElement addNewPlaylist = driver.findElement(By.xpath("//a[text()='XYZ Playlist']"));
        Assert.assertTrue(addNewPlaylist.isDisplayed());

    }

    @Test (enabled = true, priority = 3)
    public static void addSongToPlaylist (){

        //ADD SONG TO PLAYLIST TEST
        //open Koel
        navigateToTestPro();

        //Enter tester username
        provideEmail("amandaag39@gmail.com");

        //Enter password
        providePassword("te$t$tudent");

        //Click login button
        clickLoginButton();

        //navigate to 'All Songs'
        String url2="https://bbb.testpro.io/#!/songs";
        driver.get(url2);

        //right-click on song
        Actions rightClick=new Actions(driver);
        WebElement waitingOnATrainSong=driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        rightClick.contextClick(waitingOnATrainSong).perform();

        //click on add to
        WebElement addTooButton=driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]"));
        addTooButton.click();

        //click on XYZ Playlist in dropdown
        WebElement xyzPlaylistDropdown=driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[4]/ul/li[10]"));
        xyzPlaylistDropdown.click();

        //navigate to XYZ Playlist
        WebElement xyzPlaylist=driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[7]/a"));
        xyzPlaylist.click();

        //check for song in playlist
        WebElement waitingOnATrainSongPlaylist=driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr/td[2]"));
        Assert.assertTrue(waitingOnATrainSongPlaylist.isDisplayed());

    }
}
