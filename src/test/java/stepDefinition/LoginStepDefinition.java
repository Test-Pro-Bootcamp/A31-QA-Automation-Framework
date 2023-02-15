package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.nl.En;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition  {







//    @Then("I am logged in")
//    public void iAmLoggedIn() {
//                Assert.assertTrue(wait.until(ExpectedConditions
//                        .elementToBeClickable(By.cssSelector("img.avatar"))).isDisplayed());
//    }

//    @When("I enter email <username>")
  //  public void iEnterEmailUsername(String username) {
 //       LoginPage loginPage = new LoginPage(driver);
//        loginPage.provideEmail(username);
//    }

 //   @And("I enter password <password>")
 //   public void iEnterPasswordPassword(String password) {
 //       LoginPage loginPage = new LoginPage(driver);
 //       loginPage.providePassword(password);
//    }

//    @Then("I get an error message")
//    public void iGetAnErrorMessage() {
//              Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".error"))).isDisplayed());
//            //lets put this on POM/page objects
//    }
//    @Then("I get Enter Email and Password")
//    public void messageEnterEmailAndPassword(){
//        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).isDisplayed());
//    }
}
