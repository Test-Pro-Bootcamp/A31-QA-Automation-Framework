import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {

    @Test
    public void DeletePlaylistTest() throws InterruptedException {
        String playlistName = "test playlist";

        login("adeagle2021@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();
        //clickNewPlaylistOption
        WebElement NewPlaylistOption = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        NewPlaylistOption.click();
        //
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        WebElement PlaylistField = driver.findElement(By.cssSelector("input[name='name']"));
        PlaylistField.sendKeys("FinallyBro");
        PlaylistField.sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);
        WebElement Playlistname = driver.findElement(By.cssSelector("[href=\"#!/playlist/20364\"]"));
        actions.contextClick(Playlistname).perform();
        Thread.sleep(5000);
        WebElement deleteOption = driver.findElement(By.cssSelector("li:nth-child(14) ul [data-testid=\"playlist-context-menu-delete-20364\"]]"));
        actions.moveToElement(deleteOption).click(deleteOption);
        Thread.sleep(4000);

    }
}
