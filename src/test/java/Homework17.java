import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        navigatingToPage();
        Thread.sleep(5000);

        provideEmail("rinat.salimov@testpro.io");

        providePassword("rcmEq4st");

        clickOnLoginButton();
        Thread.sleep(5000);

        searchForSong("BossStatus");

        clickOnViewAllButton();

        WebElement songBossStatus = driver.findElement(By.xpath("//td[@class='title' and normalize-space()='BossStatus']"));
        songBossStatus.click();
        Thread.sleep(2000);

        WebElement addToButton = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToButton.click();

        String generatedPlaylistName = generateRandomName();

        WebElement newPlaylistName = driver.findElement(By.xpath("(//input[@data-test='new-playlist-name'])[2]"));
        newPlaylistName.click();
        newPlaylistName.sendKeys(generatedPlaylistName);

        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit' and @title='Save'])[2]"));
        saveButton.click();
        Thread.sleep(5000);

        WebElement notification = driver.findElement(By.xpath("//div[contains(@class,'success') and contains(@class,'show')]"));
        Assert.assertTrue(notification.isDisplayed());

        driver.quit();

        }

    private void clickOnViewAllButton() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
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
