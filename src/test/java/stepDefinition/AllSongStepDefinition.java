package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongPage;
import pages.LoginPage;

import java.time.Duration;

public class AllSongStepDefinition {
    protected WebDriver driver;
    protected WebDriverWait wait;


//    @Before
//    public void openBrowser() {
//        ChromeDriverManager.getInstance().setup();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//        driver.get("http://bbb.testpro.io");
//    }

//    @Before
//    public void logIn() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.logIn();
//    }

//    @After
//    public void closeBrowser() {
//        driver.quit();
//    }

    @And("User navigate to All Song Page")
    public void UserNavigateToAllSongPage() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.chooseAllSongsList();
    }

    @When("User selected first song")
    public void userSelectedFirstSong() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.selectFirstSong();
    }

    @And("User double click the song")
    public void userDoubleClickTheSong() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.doubleClickFirstSong();
    }

    @Then("The song should playing")
    public void theSongShouldPlaying() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.isSongPlaying();
    }
}
