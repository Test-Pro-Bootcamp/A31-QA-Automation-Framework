package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
        PageFactory.initElements(givenDriver, this);
    }

    //Elements
    @FindBy(css = "input[placeholder='Email Address']") WebElement emailField;
    @FindBy(css = "input[placeholder='Password']")  WebElement passwordField;
    @FindBy(css = "button[type='submit']")  WebElement loginBtn;
    @FindBy(css = "a[type='submit']")   WebElement registrationBtn;


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
