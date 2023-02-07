import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HWork21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        login("tatsianahuryeva@yahoo.com", "te$t$tudent");
        choosePlaylist();
        conTextClick();
        newName();
        Assert.assertTrue(checkPlayList());
        }
    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
    }

    public void conTextClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element= driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
    }
    public void newName() {
           WebElement inputNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
           inputNewName.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE)));
           String newPlayListName = "Tatsiana";
           inputNewName.sendKeys(newPlayListName);
           inputNewName.sendKeys(Keys.ENTER);

    }
    public boolean checkPlayList (){
        String newPlayListName = "Tatsiana";
        WebElement createdPlayList = driver.findElement(By.xpath("//a[text()='"+newPlayListName+"']"));
         return createdPlayList.isDisplayed();
    }
    }



