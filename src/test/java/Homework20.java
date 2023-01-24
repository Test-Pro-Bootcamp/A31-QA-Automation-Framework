import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework20 extends BaseTest {

    //refactoring from Homwork 19
    @Test
    public static void deletePlaylist() {

        //Log in with your credentials
        provideEmail("anupapeter@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

//        //Find playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[contains(text(),'hwk20')]"))).click();

//        //Delete Playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span/button[@class=\"del btn-delete-playlist\"]"))).click();

//        //Confirm Delete Playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"ok\"]"))).click();


        //Assert Playlist Delete
        String name = "";
        List<WebElement> listPlaylist = driver.findElements(By.xpath("//*[@id=\"playlists\"]/li/a"));
        for (WebElement el : listPlaylist) {
            name = el.getText();
            if (name.equals("hwk20")) {
                Assert.assertTrue(false);
            }
        }
    }
}
