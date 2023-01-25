import PageFactory.AllSongsPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HW23 extends BaseTest {

    @Test

    public void AddaSong (){

        LoginPage loginPage= new LoginPage(driver);
       HomePage homePage= new HomePage(driver);
       AllSongsPage allSongsPage = new AllSongsPage(driver);



       loginPage.logIn();
       homePage.ClickAllsongs();
        allSongsPage.addToFavo();
        Assert.assertTrue(allSongsPage.isSongLiked());




    }

}
