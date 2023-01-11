import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19Test extends BaseTest {

    @Test(enabled = false, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void logInEmptyEmailPasswordTest(String email, String password) {

        logIn(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(description = "Delete a PlayList")
    public void deleteEmptyPlaylist() throws InterruptedException{
        logIn("skyeman75@gmail.com", "te$t$tudent");
        verifyLogIn();
        openPlayList();
        deletePlayList();
        WebElement deletedPlaylistMessage = getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());
    }

    public void openPlayList()throws InterruptedException{
            WebElement playListSelected = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            playListSelected.click();
            Thread.sleep(3000);
        }
    private void deletePlayList()throws InterruptedException{
        WebElement deleteButton = driver.findElement(By.cssSelector("button.btn-delete-playlist"));
        deleteButton.click();
        Thread.sleep(3000);


    }
    public WebElement getDeletedPlaylistMessage(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }


}






