import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.LoginPage;

import java.util.Collections;
import java.util.List;

public class Homework19 extends BaseTest {
    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Login with valid credentials
        loginPage.login();

        List<WebElement> playlist = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'playlist')]//a"))));

        WebElement newPlaylistButton = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));

        String playlistName = homePage.generateRandomName();

        newPlaylistButton.click();

        WebElement createPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        createPlaylistButton.click();

        WebElement newPlaylistName = driver.findElement(By.cssSelector("input[name='name'][placeholder='↵ to save']"));
        newPlaylistName.click();
        newPlaylistName.clear();
        newPlaylistName.sendKeys(playlistName);
        newPlaylistName.sendKeys(Keys.ENTER);

        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist'][title='Delete this playlist']")));
        deletePlaylistButton.click();

        WebElement notification = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(notification.isDisplayed());

    }

}

