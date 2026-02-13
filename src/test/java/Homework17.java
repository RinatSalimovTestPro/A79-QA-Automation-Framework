import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        provideEmail("rinat.salimov@testpro.io");
        providePassword("rcmEq4st");

        clickOnLoginButton();

        searchForSong("BossStatus");

        clickOnViewAllButton();

        WebElement songBossStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='title' and normalize-space()='BossStatus']")));
        songBossStatus.click();

        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='add-to-btn']")));
        addToButton.click();

        String generatedPlaylistName = generateRandomName();

        WebElement newPlaylistName = driver.findElement(By.xpath("(//input[@data-test='new-playlist-name'])[2]"));
        newPlaylistName.click();
        newPlaylistName.sendKeys(generatedPlaylistName);

        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit' and @title='Save'])[2]"));
        saveButton.click();

        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'success') and contains(@class,'show')]")));
        Assert.assertTrue(notification.isDisplayed());

        driver.quit();

        }

    private void clickOnViewAllButton() {
        WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }

    private void searchForSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "").substring(0,5);
    }

}
