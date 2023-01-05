import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public static void loginPage() throws InterruptedException {

        navigateToPage();
        logintoPage();

        Thread.sleep(2000);

        WebElement allSongs = driver.findElement(By.cssSelector("a[class=\"songs\"]"));
        allSongs.click();

        Thread.sleep(2000);

        WebElement songTitle = driver.findElement(By.xpath("//td[contains(text(), 'Take my Hand')]"));
        songTitle.click();

        Thread.sleep(2000);


        WebElement addTo = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addTo.click();

        System.out.println("SFSAJ");




    }






    }
