import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public static void playSongTest () {
        provideEmail("amandaag39@gmail.com");
        providePassword("te$t$tudent");
        clickLoginButton();

        //navigate to 'All Songs'
        navigateToAllSongsPage();

        //double-click a song
        Actions action = new Actions(driver);
        WebElement playSongButton = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        action.doubleClick(playSongButton).perform();

        //verify song is playing
        WebElement soundBars = driver.findElement(By.cssSelector("img[alt=\"Sound bars\"]"));
        Assert.assertTrue(soundBars.isDisplayed());

    }
}
