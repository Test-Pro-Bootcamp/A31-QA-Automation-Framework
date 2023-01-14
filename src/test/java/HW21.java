import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HW21 extends BaseTest {

    @Test
     public void renamePlaylist() throws InterruptedException {
        login("zahinedu@gmail.com", "te$t$tudent");
        editList();
        newName();
//        doesPlaylistExist();

    }

    public void editList() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        WebElement editList = driver.findElement(By.cssSelector(".playlist:nth-child(5)"));
       actions.doubleClick(editList).perform();

    }
   public  void newName() {
        WebElement playlistInputField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")))
;
       playlistInputField.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE)));
       playlistInputField.sendKeys("HOMEWORK21");
       playlistInputField.sendKeys(Keys.ENTER);
   }
}





