package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPF extends BasePagePF {
    //WebElements
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    public LoginPF(WebDriver givenDriver) {super(givenDriver);}

    public void clickSubmitBtn(){
        submitButtonLocator.click();
    }
    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }

}
