import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test(enabled = true, priority = 3, description = "updateUserProfileTest")
    public static void updateUserProfileTest() throws InterruptedException {
        String newName = generateRandomName();


        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        openUserProfilePage();
        setName(newName);
       Thread.sleep(2000);

        provideCurrentPassword("te$t$tudent");
        clickSaveButton();
        Thread.sleep(3000);


        WebElement actualUserProfile = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualUserProfile.getText(), newName);


    }

    }


//Alternative solution pieces:

//setCurrentPassword();
// provideProfileName(randomName);
//getUserProfileField();


//       Assert.assertTrue(getSuccessPopUp().isDisplayed());
//       Assert.assertEquals(newName,getUserNameOnHeader());
//       Assert.assertEquals(newName, getUserProfileField());



//  public static String getUserProfileField() {
//        return driver.findElement(By.cssSelector("#inputProfileName")).getAttribute("_value");

// public static void provideProfileName(String randomName) {
//                WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
//                profileName.clear();
//                profileName.sendKeys(randomName);

//        public static void setCurrentPassword(String currentPassword){
//            WebElement bb = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
//            bb.click();
//            bb.sendKeys("Te$t$tudent");
//            driver.findElement(By.cssSelector(".btn-submit")).click();
//            }










