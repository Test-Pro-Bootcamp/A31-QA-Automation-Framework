package pages.HW22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AHplaylistPages extends basePage {

    WebDriver driver;
    WebDriverWait wait;
    //locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By AHplaylistPages = By.xpath("//td[.='Ketsa - Beautiful']\"");

    public AHplaylistPages(WebDriver givenDriver) {
        super(givenDriver);
    }


public void AHplaylistPages2(){
    WebElement AHplaylistPages = driver.findElement(By.xpath("//td[.='Ketsa - Beautiful']"));
 doubleClick(By.xpath("//td[.='Ketsa - Beautiful']"));


}
}
