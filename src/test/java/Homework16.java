import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        WebElement registrationButton = BaseTest.getDriver().findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("registration"));

    }
}
