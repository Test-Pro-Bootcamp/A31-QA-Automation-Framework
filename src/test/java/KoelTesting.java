import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class KoelTesting {

    public static void logIntoKoel(WebDriver driver, String userName, String password)
    {
        driver.findElement(By.cssSelector("input[placeholder='Email Address']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public static void goToKoel(WebDriver driver){
        driver.manage().window().maximize();
        driver.get("https://bbb.testpro.io/");
        waitforSeconds(driver,2);
    }

    public static void createPlaylist(WebDriver driver, String playlistName){
        driver.findElement(By.cssSelector("i[title='Create a new playlist']")).click();
        waitforSeconds(driver, 5);
        driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")).click();
        waitforSeconds(driver, 5);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(playlistName);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(Keys.ENTER);
    }

    public static void  deletePlaylist(WebDriver driver, String playlistName){
        driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName))).click();
        waitforSeconds(driver, 5);
        driver.findElement(By.cssSelector("button[title='Delete this playlist']")).click();
        waitforSeconds(driver, 5);

        try {
            driver.findElement(By.cssSelector("button[class='ok']")).click();
        }
        catch (Exception e) {}
    }

    public static void clickTabInYourMusic(WebDriver driver, String tabName){
        waitforSeconds(driver, 5);
        driver.findElement(By.cssSelector(String.format("a[href='#!/%s']", tabName))).click();
    }
    public static void waitforSeconds(WebDriver driver, int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
