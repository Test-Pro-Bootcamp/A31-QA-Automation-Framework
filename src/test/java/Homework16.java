import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void Registration(){

        //REGISTRATION TEST CASE :

        //Preconditions: Chrome Browser should be open
        //Step1: Open to 'Koel' homepage.
        //Step 2: Click on Registration
        //Step 3: Validate the Registration Page.

        //PRECONDITION:
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));

        //STEP1 : 'KOEL' HOMEPAGE:
        String url =" https://bbb.testpro.io/";
       driver.get(url);

        //STEP 2: CLICK ON REGISTRATION LINK:
        WebElement registrationField = driver.findElement(By.cssSelector("[id=\'hel\']"));
        registrationField.click();

        //STEP 3: VALIDATE REGISTRATION PAGE:

        WebElement registerField = driver.findElement(By.cssSelector("[id=\'button\']"));
        Assert.assertTrue(registerField.isDisplayed());





    }
}
