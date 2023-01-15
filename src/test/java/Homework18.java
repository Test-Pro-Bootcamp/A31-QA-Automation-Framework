import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Homework18 extends BaseTest {
    //1. Create a new file Homework18.java with @Test annotation in IntelliJ IDEA.
    //2. Create a test case playSong() using @Test annotations.
    //3. Use the helper/reusable methods we created.
    //4. Create a new config XML file for the test case.
    //5. Specify the method to be ran in the XML file.
    //6. Navigate to "https://bbb.testpro.io/".
    //7. Log in with your credentials.
    //8. Play a song.
    //9. Validate that a song is playing.
    //10. Create a new branch and commit your changes.
    //11. Push your code to a remote repository.
    //12. Create a pull request./
    @Test
    public void playSong() throws InterruptedException {
        // Navigate to Koel and login
        navigateToPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        provideEmail("rahwageb4@gmail.com");
        providePassword("texaspro2022!");
        clickSubmit();

        // Click on home window
        WebElement homeWindow = driver.findElement(By.xpath("//*[@id='sidebar']/section[1]/ul/li[1]/a"));
        homeWindow.click();

        // click on a first song from the list
        WebElement firstSong = driver.findElement(By.xpath("//*[@id='homeWrapper']/div/div[1]/section[1]/ol/li[1]/article/span[1]/a/i"));
        firstSong.click();

        Thread.sleep(3000);

        // Check if sound bar is showing up
        WebElement soundBar = driver.findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div"));
        Assert.assertTrue(soundBar.isDisplayed());

        //close chrome
        driver.quit();
    }
}
