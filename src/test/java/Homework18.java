import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


// 1. Create a new file Homework18.java with @Test annotation in IntelliJ IDEA.
//
//2. Create a test case playSong() using @Test annotations.
//
//3. Use the helper/reusable methods we created.
//
//4. Create a new config XML file for the test case.
//
//5. Specify the method to be ran in the XML file.
//
//6. Navigate to "https://bbb.testpro.io/".
//
//7. Log in with your credentials.
//
//8. Play a song.
//
//9. Validate that a song is playing.
//
//10. Create a new branch and commit your changes.
//
//11. Push your code to a remote repository.
//
//12. Create a pull request.

public class Homework18  extends BaseTest{

    @Test
    public void playASongTest() {
        login("demo@class.com", "te$t$tudent");
        playSong();
        isSongPlaying();

    }
    public void playSong() {
        WebElement playNxtBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNxtBtn.click();
        playBtn.click();
    }

    public void isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());

    }

    }
