import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Homework21 extends BaseTest{

    @Test
    public static void createPlayList() {
        login("terrence.regis@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[title='Create a new playlist']"))).click();

        WebElement newPlayList = driver.findElement(By.cssSelector("[data-testid$='create-simple']"));
        newPlayList.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']"))).click();
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Winter Songs");
        name.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class = 'success show'] "))).isDisplayed();
    }



    @Test
    public void refactorRenamePlayList()  {
        SeleniumTechniques.renamePlaylist();
    }



}
