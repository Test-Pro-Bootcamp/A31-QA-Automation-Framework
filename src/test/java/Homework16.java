import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


public class Homework16 extends BaseTest {

    @Test(enabled = true, description = "Testregistrationlink")
    public static void Registration() {

        navigateToPage();

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();
        String registrationURL = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

    }

    @Test(enabled = true, description = "Loginwvalidaccount")
    public static void validLogin() {

        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        WebElement avataricon = driver.findElement(By.cssSelector("img.avatar"));

        Assert.assertTrue(avataricon.isDisplayed());
    }
//    @Test(enabled = true, description = "ch17homeworkaddsong")
//    public static void addSong(){
//
//        navigateToPage();
//        provideEmail("kbetestack@gmail.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//
//        WebElement allSongs = driver.findElement(By.className(".songs active"));
//        allSongs.click();
//
//        WebElement chooseSong = driver.findElement(By.xpath(//td[contains( text(),'Frantic')])) ;
//        chooseSong.click();
//
//        WebElement addToPlaylist = driver.findElement(By.className(".btn-add-to"));
//        addToPlaylist.click();
//


    }


}
