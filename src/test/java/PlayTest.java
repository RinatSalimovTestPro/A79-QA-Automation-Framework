import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class PlayTest extends BaseTest {

    @Test
    void hoverOverPlayButton() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("rinat.salimov@testpro.io").providePassword("rcmEq4st").clickOnLoginButton();
        homePage.clickOnAllSongsButton();
        homePage.hoverOnPlayButton();
        Assert.assertTrue(homePage.hoverOnPlayButton().isDisplayed());
        homePage.hoverOnPlayButton().click();
        Assert.assertTrue(homePage.isSongPlaying());



    }

}
