
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

@Test
 public void playASongTest() throws InterruptedException {
navigateToPage();
login("sandra.geche@gmail.com", "te$t$tudent");
playSong();
Thread.sleep(2000);
verifyPlayingSong();
 }
}
