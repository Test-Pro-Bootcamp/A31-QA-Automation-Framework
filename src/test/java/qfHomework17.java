import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class qfHomework17 extends BaseTest {


    @Test

    public static void addSongTOPlaylist (){

        navigateToPage();
        provideEmail("quilesfielder@gmail.com");
    //    providePassword("te$tStudent");
        //clickSubmit();

       // searchSong("pluto");
      //  viewAllSearchResults();
      //  selectFirstSongResult();
       // clickAddToResult();
       // choosePlaylist("Test");


        //Navigate to "https://bbb.testpro.io

    }


    public static void provideEmail (){
        String =


    }


    public static void navigateToPage() {
        WebDriver driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));

         String url = "https://bbb.testpro.io/";
          driver.get(url);


    }


}
