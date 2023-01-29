package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {


    @FindBy(css="[type='submit']" )
   WebElement submitButton;
    @FindBy(css = "[type='email']" )
    WebElement emailField;
    @FindBy(css = "[type='password']" )
   WebElement passwordField;

    public LoginPage(WebDriver givenDriver) {
       super (givenDriver);
    }

    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;

    }

    public LoginPage providePassword(String password) {
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
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.provideEmail("skyeman75@gmail.com")
             .providePassword("te$t$tudent")
             .clickSubmitButton();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
