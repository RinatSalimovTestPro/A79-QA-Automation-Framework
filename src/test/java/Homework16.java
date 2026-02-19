import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {

        WebElement registrationButton = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("registration"));

    }
}
