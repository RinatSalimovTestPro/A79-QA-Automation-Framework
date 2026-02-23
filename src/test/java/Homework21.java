import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {

    String newPlaylistName = "Updated playlist name";

    @Test
    public void renamePlaylist() {

        String updatedPaylistMsg = "Updated playlist \"Updated playlist name.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Login with valid credentials
        loginPage.login();
        //Playlist double click
        homePage.doubleClickPlaylist();
        //Enter new playlist name
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPaylistMsg);
    }
}