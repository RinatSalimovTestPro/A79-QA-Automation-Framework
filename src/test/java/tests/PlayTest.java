package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class PlayTest extends BaseTest {

    @Test
    void hoverOverPlayButton() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("rinat.salimov@testpro.io").providePassword("rcmEq4st").clickOnLoginButton();
        homePage.clickOnAllSongsButton();
        homePage.hoverOnPlayButton();
        Assert.assertTrue(homePage.hoverOnPlayButton().isDisplayed());
        homePage.hoverOnPlayButton().click();
        Assert.assertTrue(homePage.isSongPlaying());

    }

}
