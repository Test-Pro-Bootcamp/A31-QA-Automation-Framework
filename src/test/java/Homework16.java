import org.testng.annotations.Test;

public class Homework16 extends BaseTest {

    @Test
    public void Navigation() {

        WebDriver driver = new ChromeDriver();
        driver.images().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registratinLink.click();

        String registrationUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        driver.quit();

    }
}