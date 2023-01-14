import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {


    @Test(description = "Delete an Empty PlayList")
    public void deleteEmptyPlaylist(){
        logIn("skyeman75@gmail.com", "te$t$tudent");
        verifyLogIn();
        openPlayList();
        deletePlayList();
        WebElement deletedPlaylistMessage = getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());
    }

    public void openPlayList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)"))).click();
        }
    private void deletePlayList(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist"))).click();


    }
    public WebElement getDeletedPlaylistMessage(){

        return driver.findElement(By.cssSelector("div.success.show"));
    }


}






