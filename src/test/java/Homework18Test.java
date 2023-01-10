import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class Homework18Test extends BaseTest {

    @Test(description = "Log in with Valid User Info")
    public void playSong(){
        grabUrl();
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        assertTrue(avatarIcon.isDisplayed());
        WebElement playSong = driver.findElement(By.xpath("//span[@class='play']"));
        playSong.click();

    }


}


