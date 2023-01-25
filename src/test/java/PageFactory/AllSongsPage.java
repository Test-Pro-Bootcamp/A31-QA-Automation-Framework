package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(css = "//tr[@class='song-item selected']//i[@class='fa fa-heart-o']")
    WebElement heartIcon;

    public AllSongsPage addToFavo() {
        click(heartIcon);
        return this;

    }

    @FindBy(xpath = "//tr[@class='song-item selected']//i[@class='fa fa-heart text-maroon']")
    WebElement FavoAssertion;
    public boolean isSongLiked(){
        return FavoAssertion.isDisplayed();  }



}
