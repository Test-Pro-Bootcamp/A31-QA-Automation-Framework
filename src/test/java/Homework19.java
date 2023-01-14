import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
 public void deletePlaylist(){
        login("karkisuman0330@gmail.com","te$t$tudent");
        newPlaylist();


    }




   /* public static void newPlaylist() throws InterruptedException {
        WebElement plus = driver.findElement(By.xpath("//i[@data-testid=\"sidebar-create-playlist-btn\"]"));
        plus.click();
        driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")).click();
        WebElement nameList = driver.findElement(By.cssSelector("input[name='name']"));
        nameList.sendKeys("rocksg");
        nameList.click();
        Assert.assertEquals(nameList.getText(), "rocksg");*/

}
