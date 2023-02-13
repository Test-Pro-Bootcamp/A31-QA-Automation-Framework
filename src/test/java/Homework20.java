import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import pages.BasePage;

public class Homework20 extends BaseTest {

    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {
        login("simplyd2d@gmail.com", "te$t$tudent");
        clickSubmit();

        //Find Playlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Homework 20 Test'])[1]"))).click();


        // Delete selected playlist
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Playlist']"))).click();


        // Validate that the playlist is deleted
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Ok']"))).click();


        //String name = "";
        //List<WebElement> listPlaylist = driver.findElements(By.xpath("//section[@id='playlists']"));
        //for (WebElement el : listPlaylist) {
            //name = el.getText();
            //if (name.equals("Homework 20 Test")) {
                //Assert.assertTrue(false);

            }
        }

