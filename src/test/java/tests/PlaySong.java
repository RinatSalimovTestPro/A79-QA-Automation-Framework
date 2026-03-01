package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;


public class PlaySong extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        //Login with valid credentials
        loginPage.login();

        WebElement nextSongButton = BaseTest.getDriver().findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        nextSongButton.click();
        Thread.sleep(3000);

        WebElement playButton = BaseTest.getDriver().findElement(By.cssSelector("span[data-testid='play-btn']"));
        playButton.click();
        Thread.sleep(3000);

        WebElement pauseButton = BaseTest.getDriver().findElement(By.cssSelector("span[data-testid='pause-btn']"));

        Assert.assertTrue(pauseButton.isDisplayed());

    }
}
