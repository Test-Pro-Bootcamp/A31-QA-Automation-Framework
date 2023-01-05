import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    static void setupClass() { WebDriverManager.chromedriver().setup(); }
//
//    public static void login(String email, String password) {
//        provideEmail(email);
//        providePassword(password);
//        clickSubmit();
//    }
//
//    public static void clickSubmit() {
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//        submitButton.click();
//    }
//    public static void provideEmail(String email) {
//        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//        emailField.clear();
//        emailField.sendKeys(email);
//
//    }
//    public static void providePassword (String password) {
//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        passwordField.clear();
//        passwordField.sendKeys(password);
//
//    }

}
