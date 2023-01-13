import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        login("shalinibaronia@gmail.com","te$t$tudent");
        selectPlaylist();
        deleteSelectedPlaylist();

        // Verify playlist is deleted alert appears
        WebElement alertDeleteMsg = driver.findElement(By.xpath(" //div[@class='success show']"));
        Assert.assertTrue(alertDeleteMsg.isDisplayed());
    }
}
