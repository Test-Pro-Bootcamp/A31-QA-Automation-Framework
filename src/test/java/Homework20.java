import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        login("shalinibaronia@gmail.com","te$t$tudent");
        WebElement openPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Newplaylist']")));
        openPlaylist.click();

        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Delete this playlist']")));
        deletePlaylistBtn.click();

        // Verify playlist is deleted alert appears
        WebElement alertDeleteMsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[@class='success show']")));
        Assert.assertTrue(alertDeleteMsg.isDisplayed());
    }
}

