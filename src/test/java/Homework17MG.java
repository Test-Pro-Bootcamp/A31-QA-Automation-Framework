import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17MG  extends BaseTest {

   // public static WebDriver driver = null;
    //@BeforeMethod
    //public static void launchBrowser() {
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   // }

   // @AfterMethod
   // public static void closeBrowser(){
        //driver.quit();
    //}

   //@Test
    //public static void loginValidEmailValidPasswordTest() throws InterruptedException {

       // String url = "https://bbb.testpro.io";
        //driver.get(url);

       // loginEmail("demo@class.com");
        //LoginPassword("te$t$tudent");
       // ClickLoginButton();
        //Thread.sleep(2000);


       // WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        //Assert.assertTrue(avatar.isDisplayed());

   // }

   // public static void ClickLoginButton() {
       // WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
       // loginButton.click();
    //}

    //public static void LoginPassword(String password) {
       // WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
       // passwordField.click();
       // passwordField.sendKeys("password");
   // }

    //public static void loginEmail(String email) {
       // WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        //emailField.click();
        //emailField.sendKeys("email");
    //}

    @Test
    public static void addSongToPlaylist() {

        login("demo@class.com", "te$t$tudent");

            WebElement allSongsLink = driver.findElement(By.cssSelector("[href='#!/songs']"));
            allSongsLink.click();

        addSong("tr.song-item:nth-child(10) td.title");
                //URL for LoboLogo song
        }

    public static void addSong(String songUrl) {
        WebElement songName = driver.findElement(By.cssSelector("songUrl"));
        WebElement playlistFavorites = driver.findElement(By.cssSelector("[href='#!/favorites']"));

        Actions acts = new Actions(driver);
        acts.clickAndHold(songName)
                .release(playlistFavorites)
                .build()
                .perform();

        playlistFavorites.click();
    }

}



