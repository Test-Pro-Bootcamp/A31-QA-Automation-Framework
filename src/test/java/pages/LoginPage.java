package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage( WebDriver givenDriver) {
        super(givenDriver);}
    @FindBy (css="[type='email']")
    WebElement emailFieldLocator;

    @FindBy(css="[type='password']")
    WebElement passwordFieldLocator;

    @FindBy(css ="button[type='submit']")
   WebElement submitButtonLocator;
    public LoginPage provideEmail(String email){
        emailFieldLocator.sendKeys(email);
        return this;
    }
public LoginPage providePassword (String password) {
    passwordFieldLocator.sendKeys(password);
    return this;
    }
public LoginPage clickSubmitBtn() {
    submitButtonLocator.click();
         return this;
}
public void login(){
    provideEmail("sandra.geche@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
}
}
