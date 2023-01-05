public class Homework17 extends BaseTest {


    @Test(enabled = true, description = "ch17homeworkaddsong")
    public static void addSong(){

        navigateToPage();
       provideEmail("kbetestack@gmail.com");
       providePassword("te$t$tudent");
        clickSubmit();

        WebElement allSongs = driver.findElement(By.className(".songs active"));
        allSongs.click();

        WebElement chooseSong = driver.findElement(By.xpath(//td[contains( text(),'Frantic')])) ;
        chooseSong.click();

        WebElement addToPlaylist = driver.findElement(By.className(".btn-add-to"));
       addToPlaylist.click();


}
