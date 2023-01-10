import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {

    @Test
    public static void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Precondition
        String url = "https://www.canva.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div[2]/div/header/div[6]/button[1]"));
        loginBtn.click();


        WebElement selectEmailField = driver.findElement(By.cssSelector("[class='_38oWvQ']"));
        selectEmailField.clear();
        selectEmailField.sendKeys("dagitammz@gmail.com");
    }
}
