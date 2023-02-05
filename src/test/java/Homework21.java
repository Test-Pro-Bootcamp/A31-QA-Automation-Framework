import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {


    @Test
    public void renamePlaylist() {

        // Log in with your credentials
        provideEmail("simplyd2d@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        // Selecting playlist which is to be renamed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[4]//a[1]")));
        WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//li[4]//a[1]"));
        action.doubleClick(playList).perform();


        // Enter new name for playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"name\"]")));
        WebElement plNameInputfield = driver.findElement(By.xpath("//input[@name=\"name\"]"));
        plNameInputfield.sendKeys((Keys.chord(Keys.DELETE)));
        plNameInputfield.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE)));
        plNameInputfield.sendKeys("Homework21");
        plNameInputfield.sendKeys(Keys.ENTER);

        // Check if renamed playlist exists
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]//a[contains(text(),'Homework21')]")));
        WebElement playlistElement = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[contains(text(),'Homework21')]"));
        Assert.assertTrue(playlistElement.isDisplayed());

    }

}





