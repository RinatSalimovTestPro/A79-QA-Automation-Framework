import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

        navigatingToPage();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() {
        provideEmail("rinat.salimov@testpro.io");
        providePassword("rcmEq4st");
        clickOnLoginButton();

        WebElement avatarIcon_v2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon_v2.isDisplayed());

    }
}
