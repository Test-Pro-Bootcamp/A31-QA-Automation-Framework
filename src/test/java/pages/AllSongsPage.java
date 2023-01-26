package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver)
    {
        super(givenDriver);
        PageFactory.initElements(givenDriver, this);
    }

    //Web Elements
    @FindBy(xpath = "//button[@class='btn-add-to']") WebElement addToBtn;
    @FindBy(xpath = "//td[contains(text(),'%s')]") WebElement songElement;


    public void addSongInPlaylist(String song, String playlist)
    {
        click(findElement(By.xpath(String.format("//td[contains(text(),'%s')]", song))));
        click(addToBtn);        //Click the add to button
        click(findElement(By.xpath(String.format("//section[@id='songsWrapper']/header/div/div/section/ul/li[contains(text(),'%s')]" ,playlist))));
    }
}
