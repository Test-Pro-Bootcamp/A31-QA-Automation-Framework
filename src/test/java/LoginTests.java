import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class)
    public static void loginEmptyEmailPasswordTest(String email, String password) {

        login(email,password);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
//moving this to ProfileTests
//    @Test
//    public static void updateProfileNameTest () throws InterruptedException {
//
//        navigateToPage();
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//
//        Thread.sleep(2000);
//        clickavatarIcon();
//
//        String randomName = generateRandomName();
//
//            provideCurrentPassword("te$t$tudent");
//            provideProfileName(randomName);
//            clickSaveButton();
//
//        Thread.sleep(2000);
//            WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
//            Assert.assertEquals(actualProfileName.getText(), randomName);
//}

}

