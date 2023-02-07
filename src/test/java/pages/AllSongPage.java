package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongPage  extends BasePage{
    public static Action action = null;
    public AllSongPage(WebDriver givenDriver) {super(givenDriver);}
    public void contextClickFirstSong(){
   //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector()));
    }
}
