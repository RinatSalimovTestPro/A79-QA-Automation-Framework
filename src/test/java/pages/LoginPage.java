package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement logInButton;

    public LoginPage provideEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton() {
        (logInButton).click();
    }

    public  void login() {
        provideEmail("rinat.salimov@testpro.io");
        providePassword("rcmEq4st");
        clickOnLoginButton();
    }

    public boolean isLoginFormDisplayed() {
        return !driver.findElements(org.openqa.selenium.By.cssSelector("input[type='email']")).isEmpty()
                && emailField.isDisplayed()
                && passwordField.isDisplayed()
                && logInButton.isDisplayed();
    }
}
