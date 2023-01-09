import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() throws InterruptedException {
        login("adeagle2021@gmail.com", "te$t$tudent");
        playaSong1();
        isSongPlayingRn();



    }

}