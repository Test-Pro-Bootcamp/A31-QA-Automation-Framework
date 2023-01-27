package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends LoginPage {

    //locators

    @FindBy(css=".playlist.favorites:nth-child(1)")
    WebElement favoritesLocator;

    public FavoritesPage(WebDriver givenDriver) {super(givenDriver); }

    public WebElement getFavoritesPage () {return findElement(favoritesLocator);}

}
