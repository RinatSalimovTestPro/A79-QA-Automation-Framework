import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {

        provideEmail("rinat.salimov@testpro.io");
        providePassword("rcmEq4st");

        clickOnLoginButton();
        Thread.sleep(5000);

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
