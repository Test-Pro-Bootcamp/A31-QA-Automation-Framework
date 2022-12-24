import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


/* 1. Create a new file Homework14.java file in IntelliJ IDEA .
     2. Create a test case registration Navigation() using @Test annotation.
     3. Using Selenium, Navigate to "https://bbb.testpro.io/".
     4. Click Registration link.
     5. Validate that you are redirected to Registration page.
     6. Create a new branch and commit your changes.
     7. Push your code to a remote repository.
     8. Create a pull request.*/

public class Homework14 extends BaseTest {

    @Test
    public static void RegistrationNavigation() throws InterruptedException{

      //Open Chrome Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //Get Url
      String url = "https://bbb.testpro.io/";
      driver.get(url);

      //Locate Registration Element
        WebElement RegiLink = driver.findElement(By.cssSelector("[id='hel']"));

      //Click
        RegiLink.click();
        Thread.sleep(5000);
      //Validate Redirected page
        String RegiUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(),RegiUrl);
        driver.quit();

    }

}
