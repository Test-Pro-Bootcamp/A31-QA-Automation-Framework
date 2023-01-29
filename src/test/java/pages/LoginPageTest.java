package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {


    @FindBy(css="[type='submit']" )
   WebElement submitButton;
    @FindBy(css = "[type='email']" )
    WebElement emailField;
    @FindBy(css = "[type='password']" )
   WebElement passwordField;

    public LoginPageTest(WebDriver givenDriver) {
       super (givenDriver);
    }

    public LoginPageTest clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public LoginPageTest provideEmail(String email) {
        emailField.sendKeys(email);
        return this;

    }

    public LoginPageTest providePassword(String password) {
        passwordField.sendKeys(password);
        return this;

    }
    public void logIn(){
        provideEmail("skyeman75@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }


    @Test
    public void loginValidEMailPasswordTest() {
    LoginPageTest loginPage = new LoginPageTest(driver);
    HomePageTest homePage = new HomePageTest(driver);
    loginPage.provideEmail("skyeman75@gmail.com")
             .providePassword("te$t$tudent")
             .clickSubmitButton();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
