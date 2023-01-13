import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class KoelTesting {

    public static WebDriver driver;
    public static Actions action;
    public static WebDriverWait wait;

    @BeforeMethod
    @Parameters({"baseURL", "loginEmail", "loginPassword"})
    public void beforeMethod(String baseURL, String loginEmail, String loginPassword)
    {
        driver = new FirefoxDriver();
        action  = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    }

    public static void logIntoKoel(String userName, String password)
    {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email Address']")));
        emailField.sendKeys(userName);
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
        passwordField.sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }



    public static void createPlaylist(String playlistName)
    {
        //Click create new playlist button
        WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[title='Create a new playlist']")));
        elementWait.click();
        //Click simple playlist option
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        elementWait.click();
        //Input playlist name
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(playlistName);
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(Keys.ENTER);
    }

    public static void  deletePlaylist(String playlistName){
        //Click on the playlist
        WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//a[contains(text(),'%s')]", playlistName))));
        elementWait.click();
        //Click the delete playlist button
        elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Delete this playlist']")));
        elementWait.click();
        //Try to press the ok button, in the case of deleting a playlist that is not empty
        try {
            driver.findElement(By.cssSelector("button[class='ok']")).click();
        }catch (Exception e) {}
    }

    public static void clickTabInYourMusic(String tabName){
        WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(String.format("a[href='#!/%s']", tabName))));
        elementWait.click();
    }

    public void playTheSong(String name)
    {
        clickTabInYourMusic("songs");
        WebElement elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//td[contains(text(), '%s')]", name))));
        action.doubleClick(elementWait).build().perform();
    }
}
