import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {
    @Test(enabled=true, priority = 0, groups = {"Smoke", "Regression"}, description = "Registration with valid email")
    public void registrationValidEmail() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        registrationPage.registrationLink();
        registrationPage.registrationPage();
        registrationPage.registrationEmail();
        registrationPage.registerButton();

        Assert.assertTrue(registrationPage.registrationSuccessMsg().isDisplayed());
    }

}
