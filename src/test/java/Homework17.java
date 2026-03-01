import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login with valid credentials
        loginPage.login();

        //Search for song BossStatus
        homePage.searchForSong("BossStatus");

        //Clicking on View all button
        homePage.clickOnViewAllButton();

        WebElement songBossStatus = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='title' and normalize-space()='BossStatus']")));
        songBossStatus.click();

        WebElement addToButton = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
        addToButton.click();

        String generatedPlaylistName = homePage.generateRandomName();

        WebElement newPlaylistName = BaseTest.getDriver().findElement(By.xpath("(//input[@data-test='new-playlist-name'])[2]"));
        newPlaylistName.click();
        newPlaylistName.sendKeys(generatedPlaylistName);

        WebElement saveButton = BaseTest.getDriver().findElement(By.xpath("(//button[@type='submit' and @title='Save'])[2]"));
        saveButton.click();

        WebElement notification = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'success') and contains(@class,'show')]")));
        Assert.assertTrue(notification.isDisplayed());

    }
}


