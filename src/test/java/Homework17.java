import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {


    @Test
    public static void loginPage() throws InterruptedException {

        navigateToPage();
        logintoPage();
        updateProfile();
        Thread.sleep(2000);





        Thread.sleep(2000);


        WebElement newPassword = driver.findElement(By.cssSelector("[name='new_password']"));
        newPassword.click();
        newPassword.sendKeys("teststudent");

        WebElement saveButton = driver.findElement(By.cssSelector("[class='btn-submit']"));
        saveButton.click();








    }






    }
