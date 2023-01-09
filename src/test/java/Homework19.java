import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("hand923@gmail.com", "te$t$tudent");
        choosePlaylist();
        deleteSelectedPlaylist();
        isDeleted();
        Thread.sleep(1500);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement customPlaylist = driver.findElement(By.xpath("//li[@class='playlist playlist']//a[contains(text(), '"+playlistName+"')]"));
        customPlaylist.click();
        Thread.sleep(1000);
    }
    public void deleteSelectedPlaylist() throws InterruptedException {
        WebElement clickDelete = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        clickDelete.click();
        Thread.sleep(1000);
    }
    public boolean isDeleted() {
        WebElement isDeletedMessage = driver.findElement(By.xpath("//div[@class='alertify-logs top right']//div[contains(text(), 'Deleted playlist')]"));
        return isDeletedMessage.isDisplayed();
    }
}
