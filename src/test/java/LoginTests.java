import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(enabled = true, priority = 0, description = "LoginEmptyEmailPasswordTest")
    public static void LoginEmptyEmailPasswordTest () {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test(enabled = true, priority = 1, description = "LoginValidEmailValidPasswordTest")
    public static void LoginValidEmailValidPasswordTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test(enabled = true, priority = 2, description = "LoginInvalidEmailValidPasswordTest")
    public static void LoginInvalidEmailValidPasswordTest () {

        navigateToPage();

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test(enabled = true, priority = 3, description = "LoginValidEmailValidPasswordTest")
    public static void updateProfileNameTest () throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);

    }

    @Test(enabled = true, priority = 4, description = "AddSongToPlaylist")


    public static void addSongToPlaylistTest() throws InterruptedException {

        navigateToPage();

        provideEmail("rykov.rg@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);

        allSongsPage();

          WebElement chooseSong = driver.findElement(By.xpath("//*[@id='songsWrapper']/div/div/div[1]/table/tr[2]/td[2]"));
          chooseSong.click();

        addSongButton();
        addToPlaylist();

          Thread.sleep(2000);


          WebElement successPopUp = driver.findElement(By.cssSelector("div[class='success show']"));
          Assert.assertTrue(successPopUp.isDisplayed());

    }


}

//    @Test
//    public static void RegistrationLinkNavigationTest() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//
//        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
//        registrationLink.click();
//
//
//        WebElement title = driver.findElement(By.cssSelector("[style='padding: 32px 0; text-align: center;']"));
//        Assert.assertTrue(title.isDisplayed());
//
//        Thread.sleep(3000);
//
//        driver.quit();
//

//    }
//}

