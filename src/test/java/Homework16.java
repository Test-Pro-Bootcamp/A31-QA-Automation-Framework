import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 {
    @Test
    public void Navigation() throws InterruptedException {
        // 1. Create a new file Homework16.java in IntelliJ IDEA.
        // 2. Create a test case registration Navigation() using @Test annotation.
        // 3. Using Selenium, Navigate to "https://bbb.testpro.io/".
        // 4. Click Registration link.
        // 5. Validate that you are redirected to Registration page.
        // 6. Create a new branch and commit your changes.
        // 7. Push your code to a remote repository.
        // 8. Create a pull request.

        WebDriver driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement registrationButton = driver.findElement(By.id("hel"));
        registrationButton.click();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/registration.php");

        driver.quit();
    }

}
