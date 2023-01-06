import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework17_PB extends BaseTest{


    /* 1.Create a new file Homework17.java with @Test annotation in IntelliJ IDEA.
       2.Create a test case addSongToPlaylist() using @Test annotations and the helper/reusable methods we created.
       3. Navigate to "https://bbb.testpro.io/"
       4. Log in with your credentials.
       5. Add a song to a playlist.
       6. Validate that there is a song added.
       7. Create a new branch and commit your changes.
       8. Push your code to a remote repository.
       9. Create a pull request.*/
     @Test
    public static void addSongToPlaylist () throws InterruptedException {
        /* steps
        1.Navigate to Koel page
        2.Enter Email Address and Password.
        3.Login to Koel.
        4.Locate All Songs
        5.Locate 1st song from list
        6.locate AddTo button and click on it
        7.locate Test playlist.
        8.Validate song is added validate notification
         */
         navigateToPage();
         provideEmail("pooja.bankar@testpro.io");
         providePassword("te$t$tudent");
         clickSubmit();
         Thread.sleep(5000);
         clickAllSongsTab();


         }
    //Locate All Songs
         public void clickAllSongsTab() throws InterruptedException {
             WebElement allSongsTabField = driver.findElement(By.cssSelector("a.songs"));
             allSongsTabField.click();
             Thread.sleep(3000);
    }

        //cssSelector for AddTo Button :"button.btn-add-to"
        //cssSelector for Add to = "ul>li.has-sub" .....context menu not required
        //cssSelector for ADD to arrow = ".menu.submenu.menu-add-to".....Context menu not required.
        //Css Selector for 1st song in the list All Songs = "tr.song-item.playing.selected:first-of-type"


    // Locate first song from All Songs List
    public void selectFirstSongFromAllSongs() throws InterruptedException{
         WebElement selectFirstSongField = driver.findElement(By.cssSelector("tr.song-item.playing.selected:first-of-type"));
         selectFirstSongField.click();
        Thread.sleep(3000);
    }

    //locate AddTo button and click on it
    public void addToButton() throws InterruptedException{
         WebElement addSelectedSong = driver.findElement(By.cssSelector("button.btn-add-to"));
         addSelectedSong.click();
         Thread.sleep(3000);
    }


}
