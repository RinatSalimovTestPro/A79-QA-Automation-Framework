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

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Entering email address
        loginPage.provideEmail("invalid@testpro.io");
        //Entering password
        loginPage.providePassword("rcmEq4st");
        //Click on log in button
        loginPage.clickOnLoginButton();
        //validating if user is logged in
        Assert.assertFalse(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailPassword() {

        navigatingToPage();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();

        WebElement avatarIcon_v2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon_v2.isDisplayed());

    }
}
