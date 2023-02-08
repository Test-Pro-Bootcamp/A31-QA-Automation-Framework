import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylistTest(){
        login("demo@class.com", "te$t$tudent");
        rightClickPlaylist();
        deletePlaylist();
        verifyPlaylistIsDeleted();

        closeBrowser();
    }

}
