import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test(enabled = true,priority = 0,groups = {"Smoke","Regression"}, description = "Regestration Navigation Test")
    public void registrationNavigationTest(){
        RegistrationPage registrationPage=new RegistrationPage(getDriver());
        registrationPage.clickRegistrationLink();

        String regiURL= "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(getDriver().getCurrentUrl(),regiURL);
    }

    @Test(enabled=true,priority = 1,groups = {"Regression"}, description = "Registration with valid email")
    public void registrationValidEmailTest() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        registrationPage.clickRegistrationLink();
        registrationPage.validateRegisterNewAccountTextPresent();
        registrationPage.enterRegistrationEmail("defh12358@test.com");
        registrationPage.registerBtn();

        Assert.assertTrue(registrationPage.showRegistrationSuccessMsg().isDisplayed());
    }
}
