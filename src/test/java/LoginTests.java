import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        navigatingToPage();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        navigatingToPage();
        Thread.sleep(3000);

        provideEmail("rinat.salimov@testpro.io");

        providePassword("rcmEq4st");

        clickOnLoginButton();
        Thread.sleep(5000);

        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
}
