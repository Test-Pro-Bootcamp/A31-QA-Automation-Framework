
import org.testng.annotations.Test;

import java.time.Duration;


public class HW17 extends MyBaseTest {


 @Test
 public void addASongToPlaylist(){

  navigateToPage();
  login("zahinedu@gmail.com","te$t$tudent");
  searchSong("take my hand");
  clickviewAll ();
  addField ();
  addToField();
  verifyAddField ();
  songField();
}
}