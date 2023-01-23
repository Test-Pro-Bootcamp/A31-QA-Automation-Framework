package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends LoginPage {

    //locators
    By favoritesLocator = By.cssSelector(".playlist.favorites:nth-child(1)");

    public FavoritesPage(WebDriver givenDriver) {super(givenDriver); }

    public WebElement getFavoritesPage () {return findElement(favoritesLocator);}

}
