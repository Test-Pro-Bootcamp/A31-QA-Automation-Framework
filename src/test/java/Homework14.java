import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework14 extends BaseTest {

    @Test
    public static void Navigation() throws InterruptedException{
        //test: registration page navigation
        //precondition: chrome browser is opened
        //step 1: navigate to koel login page
        //step 2: click registration link
        //expected result: user should be taken to koel registration page

        //init webdriver, set waits
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //step 1: navigate to koel login page
        String loginPageUrl = "https://bbb.testpro.io/";
        driver.get(loginPageUrl);
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), loginPageUrl);
        Thread.sleep(1000);

        //step 2: click registration link //find registration link //click it
        WebElement registrationLink = driver.findElement(By.id("hel"));
        registrationLink.click();
        Thread.sleep(1000);

        //confirm user is taken to koel registration page //registration button is visible
        String registrationPageUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationPageUrl);
        WebElement registrationButton = driver.findElement(By.id("button"));
        Assert.assertTrue(registrationButton.isDisplayed());
        Thread.sleep(1000);

        driver.quit();

    }
}
