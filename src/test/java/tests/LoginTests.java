package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    @Test
    public void loginInvalidEmailValidPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Entering email address
        loginPage.provideEmail("invalid@testpro.io");
        //Entering password
        loginPage.providePassword("rcmEq4st");
        //Click on log in button
        loginPage.clickOnLoginButton();
        //validating if user is logged in
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form should still be displayed");
    }

    @Test
    public void loginEmptyEmailPassword() {

        navigatingToPage();

        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login();

        WebElement avatarIcon_v2 = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon_v2.isDisplayed());

    }
}
