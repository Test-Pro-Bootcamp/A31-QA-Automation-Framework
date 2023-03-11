import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyUserCanViewArtistPage(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nicoleliano@testpro.io");
        loginPage.providePassword("te$tpa$$word");
    }



    @Test(dataProvider = "IncorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void loginEmptyEmailPasswordTest (String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login(email, password);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
<<<<<<< Updated upstream

    @Test
    public void loginValidEmailValidPasswordTest (){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        homePage.getUserAvatar();

    }

    @Test
    public void loginInvalidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("invalid@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
=======
//
//    @Test
//    public void loginValidEmailValidPasswordTest (){
//
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = new HomePage(driver);
//
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmitBtn();
//
//        homePage.getUserAvatar();
//
//    }
//
//    @Test
//    public void loginInvalidEmailValidPasswordTest() {
//
//        LoginPage loginPage = new LoginPage(driver);
//
//        loginPage.provideEmail("invalid@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmitBtn();
//
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//    }
>>>>>>> Stashed changes

}
