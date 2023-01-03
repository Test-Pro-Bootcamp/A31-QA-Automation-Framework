import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework17Test extends BaseTest {

@Test
public void validLoginEmailPasswordTest(){
    openLoginURL();
    enterEmail();
    enterPassword();
    clickButton();
    WebElement avatarIcon =driver.findElement(By.cssSelector("[alt='Avatar of student']"));
    Assert.assertTrue(avatarIcon.isDisplayed());
}


}
