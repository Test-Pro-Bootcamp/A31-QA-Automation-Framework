import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

}