import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(5000);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys("rinat.salimov@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys("rcmEq4st");

        WebElement logInButton = driver.findElement(By.cssSelector("[type='submit']"));
        logInButton.click();

        Thread.sleep(5000);

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("BossStatus");

        WebElement viewAllButton = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);

        WebElement songBossStatus = driver.findElement(By.xpath("//td[@class='title' and normalize-space()='BossStatus']"));
        songBossStatus.click();
        Thread.sleep(2000);

        WebElement addToButton = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToButton.click();

        WebElement newPlaylistName = driver.findElement(By.xpath("(//input[@data-test='new-playlist-name'])[2]"));
        newPlaylistName.click();
        newPlaylistName.sendKeys("TestPlaylist");

        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='submit' and @title='Save'])[2]"));
        saveButton.click();
        Thread.sleep(5000);

        WebElement notification = driver.findElement(By.xpath("//div[contains(@class,'success') and contains(@class,'show')]"));
        Assert.assertTrue(notification.isDisplayed());

        driver.quit();




        }
}
