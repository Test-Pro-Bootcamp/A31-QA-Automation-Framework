import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://bbb.testpro.io/");

        WebElement link = driver.findElement(By.cssSelector("#hel"));
        //link.click();

        if (driver.getPageSource().contains("Register new account")){
            System.out.println("Got redirected");
        } else {
            System.out.println("Didn't get redirected");
        }
    }
}
