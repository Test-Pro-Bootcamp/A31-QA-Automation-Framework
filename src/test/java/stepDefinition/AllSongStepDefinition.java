package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
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
    WebDriver driver;
    WebDriverWait wait;

//    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
//    WebElement firstSong;
//    @FindBy(css = "[type='email']")
    //   WebElement emailField;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://bbb.testpro.io");
    }

    @Before
    public void loginI() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("tatsianahuryeva@yahoo.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("User navigate to All Song Page")
    public void UserNavigateToAllSongPage() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.chooseAllSongsList();
        //      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }

    @When("User selected first song")
    public void userSelectedFirstSong() {
        AllSongPage allSongPage = new AllSongPage(driver);
        allSongPage.selectFirstSong();

        //     wait.until(ExpectedConditions.visibilityOf(firstSong));
        //     WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        //      firstSong.click();
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
      //  Assert.assertTrue(allSongsPage.isPlaying().isDisplayed());
    }
}
