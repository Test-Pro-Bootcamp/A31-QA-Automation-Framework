import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Home20work {
    static WebDriverWait wait=null;

    @Test
    private static void registration1() {

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("[id='hel']")));
        //driver.findElement(By.id("[id='hel']"));
        registrationButton1.click();


        WebElement registerButton1 = driver.findElement(By.id("[id='button']"));
        Assert.assertTrue(registerButton1.isDisplayed());

        driver.quit();
    }

}