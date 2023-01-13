import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HWork21 extends BaseTest {

    @Test
    public void renamePlaylist(){
        login("tatsianahuryeva@yahoo.com","te$t$tudent");

        WebElement element = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        Actions action1 = new Actions(driver);
        action1.doubleClick();

        WebElement inputNewName;
        inputNewName=driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        inputNewName.clear();
        wait.until(ExpectedConditions.visibilityOf(inputNewName));
        inputNewName.sendKeys("newPlayListName");
        inputNewName.sendKeys(Keys.ENTER);

    }
}
