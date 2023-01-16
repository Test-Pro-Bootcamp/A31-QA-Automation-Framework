import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

@Test
    public static void renamePlaylist() throws InterruptedException {
        login("adeagle2021@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='name']")));

    WebElement Playlist = driver.findElement(By.xpath("//a[@href=\"#!/playlist/38496\"]"));
    Actions actions = new Actions(driver);
    actions.contextClick(Playlist).perform();
    WebElement EditOption = driver.findElement(By.xpath("//li[@data-testid=\"playlist-context-menu-edit-38496\"]"));
    EditOption.click();
    Thread.sleep(3000);
    WebElement EditInput = driver.findElement(By.xpath("//input[@type='text"));
    actions.sendKeys(EditInput,"ALi");



    Thread.sleep(5000);






    }







}
