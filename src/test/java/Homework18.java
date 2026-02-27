import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;


public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);

        //Login with valid credentials
        loginPage.login();

        WebElement nextSongButton = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSongButton.click();
        Thread.sleep(3000);

        WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(3000);

        WebElement pauseButton = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));

        Assert.assertTrue(pauseButton.isDisplayed());

    }
}
