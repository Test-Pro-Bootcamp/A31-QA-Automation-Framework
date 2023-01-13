import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {

    @Test
    public static void deletePlayList() throws InterruptedException {
       login("terrence.regis@gmail.com", "te$t$tudent");
       Thread.sleep(2000);

       createPlayList();
       Thread.sleep(2000);

       confirmCreated();
       Thread.sleep(2000);


       deleteList();
        Thread.sleep(2000);

       confirmDeleted();
        Thread.sleep(2000);
    }

       public static void createPlayList() {
           WebElement playList = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
           playList.click();

           WebElement newPlayList = driver.findElement(By.cssSelector("[data-testid$='create-simple']"));
           newPlayList.click();

           WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
           name.click();
           name.sendKeys("playlist1");
           name.sendKeys(Keys.RETURN);
       }

      public static void deleteList()  {
          WebElement delete = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
          delete.click();
      }


      public static void confirmCreated() {
        WebElement confirmation = driver.findElement(By.cssSelector("[class = 'success show'] "));
        Assert.assertTrue(confirmation.isDisplayed());
      }

       public static void confirmDeleted() {
           WebElement confirmation = driver.findElement(By.cssSelector("[class='success show']"));
           Assert.assertTrue(confirmation.isDisplayed());
       }


}


