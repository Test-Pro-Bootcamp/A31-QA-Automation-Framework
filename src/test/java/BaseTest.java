import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String url = "https://bbb.testpro.io/";
        driver.get(url);




    public void login (String email, String password) {
        userEmail(email);
        userPassword(password);
        clickSubmit();

    }

    public static void clickSubmit() {
WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
submitButton.click();


    }












    }

}
