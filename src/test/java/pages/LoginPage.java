package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    //Selectors
    By emailField = By.cssSelector("input[placeholder='Email Address']");
    By passwordField = By.cssSelector("input[placeholder='Password']");
    By loginBtn = By.cssSelector("button[type='submit']");
    By registrationBtn = By.cssSelector("a[type='submit']");

    public void enterUsername(String username)
    {
        checkElement(emailField).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        checkElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn()
    {
        click(loginBtn);
    }

    public void clickRegistrationBtn()
    {
        click(registrationBtn);
    }
}
