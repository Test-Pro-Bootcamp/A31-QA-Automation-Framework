import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 extends BaseTest{

    @Test
    public static void search() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
                driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        WebElement loginField = driver.findElement(By.cssSelector("[type='submit'"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password'"));

        emailField.click();
        emailField.sendKeys("dirzo@gmail.com");

        passwordField.click();
        passwordField.sendKeys("Te$ter1234");

        loginField.click();

        WebElement searchBar = driver.findElement(By.cssSelector("[type='search'"));

        searchBar.click();
        searchBar.sendKeys("Pluto");



        WebElement searchResult;
        searchResult = driver.findElement(By.id("searchExcerptsWrapper"));
        Assert.assertTrue(searchResult.isDisplayed());

        if (searchResult.isDisplayed()) {
            WebElement songTitle = driver.findElement(By.linkText(" Pluto "));
            Assert.assertTrue(songTitle.isDisplayed());
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
