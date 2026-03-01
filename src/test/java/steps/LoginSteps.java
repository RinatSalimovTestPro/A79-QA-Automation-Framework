package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Given("User opens login page")
    public void openPage() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @When("User enters valid credentials")
    public void enterCredentials() {
        loginPage.provideEmail("rinat.salimov@testpro.io");
        loginPage.providePassword("rcmEq4st");
    }

    @And("User clicks login button")
    public void clickLogin() {
        loginPage.clickOnLoginButton();
    }

    @Then("User should see avatar")
    public void validateLogin() {
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
