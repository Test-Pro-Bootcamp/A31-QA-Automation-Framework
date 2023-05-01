package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static stepDefinition.Hooks.getDriver;

public class PlaySongStepDefinition {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions acts;

    @Before("@playsong")
    public void setDriver(){
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(250));
        acts = new Actions(driver);
    }

    @And("I am logged in and on the home page")
    public void iLogin(){
        LoginPage lp = new LoginPage(driver);
        lp.logIn();

        wait.until(ExpectedConditions.urlContains("home"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/home");
    }

    @When("I click on All Songs")
    public void iClickOnAllSongs(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.menu a.songs"))).click();
    }

    public String selectedSongTitle;
    @And("I double click a song")
    public void iDoubleClickASong(){
        wait.until(ExpectedConditions.urlContains("songs"));

        WebElement songsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.items")));
        List<WebElement> songs = songsContainer.findElements(By.cssSelector("td.title"));

        Random rand = new Random();
        int songIndex = rand.nextInt(songs.size());

        selectedSongTitle = songs.get(songIndex).getText();

        acts.doubleClick(songs.get(songIndex)).perform();
    }

    @Then("the song should start playing")
    public void isSongPlaying(){
        WebElement progressBarSongTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#progressPane h3.title")));

        Assert.assertEquals(selectedSongTitle, progressBarSongTitle.getText());
    }

    @And("the sound visualizer should be displayed")
    public void isVisualizerDisplayed(){
        WebElement soundbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));

        Assert.assertTrue(soundbar.isDisplayed());
    }
}
