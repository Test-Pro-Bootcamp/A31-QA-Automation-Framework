import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String playlistname ="Homework21 Test";

    @Test
    public void renamePlaylist() throws InterruptedException {
        login("simplyd2d@gmail.com", "te$t$tudent");
        clickSubmit();
        choosePlaylist();
        rightClickPlaylistNam();
        clickEditOption();
        //contextClickChoosePlaylist();
        enterPlaylistName();

        Assert.assertTrue(doesPlaylistExist());
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/40418']"))).click();
    }

    public void rightClickPlaylistNam() {
        WebElement Playlist = driver.findElement(By.xpath("//a[normalize-space()='Homework21']"));
        Actions actions = new Actions(driver);
        actions.contextClick(Playlist).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Edit']")));
    }
    public static void clickEditOption() throws InterruptedException {
        WebElement EditOption = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-edit-40418']"));
        EditOption.click();
       Thread.sleep(4000);
    }
    //public void contextClickChoosePlaylist(){
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-testid='playlist-context-menu-edit-40418']")));
       // WebElement playlistElement = driver.findElement(By.cssSelector(""));
       // Actions action = new Actions(driver);
       // action.contextClick(playlistElement).perform();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))).click();
    //}

    //public static void enterPlaylistName(){
        //WebElement playlistInputField = driver.findElement(By.cssSelector(""));
        //playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        //playlistInputField.sendKeys(Homework21 Test);
        //playlistInputField.sendKeys(Keys.ENTER);
    //}
    public static void enterPlaylistName() throws InterruptedException {
        String playListName = "Homework21 New Playlist";
        WebElement EditInput = driver.findElement(By.cssSelector("input[name='name']"));
        Actions actions = new Actions(driver);
        actions.doubleClick().perform();
        EditInput.sendKeys((Keys.chord(Keys.DELETE)));
        EditInput.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        EditInput.sendKeys(playListName);
        EditInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    public boolean doesPlaylistExist(){
        WebElement playlistElement = driver.findElement(By.xpath("//a[normalize-space()='Homework21 New Playlist']"));
        return playlistElement.isDisplayed();

    }
}

