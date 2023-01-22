import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    Actions a = new Actions(driver);
    WebDriverWait wait = null;

    @Test
    public void renamePlaylist() {
        login("karkisuman0330@gmail.com", "te$t$tudent");
        createPlaylist();
        typePlaylistName();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void createPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"))).click();
        driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")).click();
        WebElement nameList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        nameList.sendKeys("rocksg", Keys.ENTER);
    }


    public void typePlaylistName() {
        WebElement choose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()='rocksg']")));
        a.doubleClick(choose);
        choose.clear();
        choose.sendKeys("songforall", Keys.ENTER);
       WebElement choose1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[text()='songforall']")));
        Assert.assertTrue(choose1.isDisplayed());


    }

}