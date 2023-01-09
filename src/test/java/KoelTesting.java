import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class KoelTesting {

    public static WebDriver driver;
    public static Actions action;

    @BeforeMethod
    @Parameters({"baseURL", "loginEmail", "loginPassword"})
    public void beforeMethod(String baseURL, String loginEmail, String loginPassword)
    {
        driver = new FirefoxDriver();
        action  = new Actions(driver);
        goToKoel(baseURL);
        logIntoKoel(loginEmail, loginPassword);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }


    public static void goToKoel(String url)
    {
        driver.manage().window().maximize();
        driver.get(url);
        waitforSeconds(2);
    }

    public static void logIntoKoel(String userName, String password)
    {
        driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }



    public static void createPlaylist(String playlistName)
    {
        driver.findElement(By.cssSelector("i[title='Create a new playlist']")).click();
        waitforSeconds(5);
        driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")).click();
        waitforSeconds(5);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(playlistName);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(Keys.ENTER);
    }

    public static void  deletePlaylist(String playlistName){
        driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName))).click();
        waitforSeconds(5);
        driver.findElement(By.cssSelector("button[title='Delete this playlist']")).click();
        waitforSeconds(5);

        try {
            driver.findElement(By.cssSelector("button[class='ok']")).click();
        }
        catch (Exception e) {}
    }

    public static void clickTabInYourMusic(String tabName){
        waitforSeconds(5);
        driver.findElement(By.cssSelector(String.format("a[href='#!/%s']", tabName))).click();
    }
    public static void waitforSeconds(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void playTheSong(String name)
    {
        clickTabInYourMusic("songs");
        waitforSeconds(5);
         action.doubleClick(driver.findElement(By.xpath(String.format("//td[contains(text(), '%s')]", name)))).build().perform();
    }




}
