import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.UUID;

public class Homework19 extends BaseTest {
    @Test
    @Parameters("baseUrl")
    public void deletePlaylist(String baseUrl) throws InterruptedException {

        driver.get(baseUrl);

        provideEmail("rinat.salimov@testpro.io");
        providePassword("rcmEq4st");
        clickOnLoginButton();
        Thread.sleep(5000);

        List<WebElement> playlist = driver.findElements(By.xpath("//li[contains(@class,'playlist')]//a"));

        WebElement newPlaylistButton = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));

        String playlistName = generateRandomName();

        if  (playlist.size() >= 3) {
            playlist.get(2).click();
        } else  {
            newPlaylistButton.click();

            WebElement createPlaylistButton = driver.findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
            createPlaylistButton.click();

            WebElement newPlaylistName = driver.findElement(By.cssSelector("input[name='name'][placeholder='↵ to save']"));
            newPlaylistName.click();
            newPlaylistName.clear();
            newPlaylistName.sendKeys(playlistName);
            newPlaylistName.sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);

        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist'][title='Delete this playlist']"));
        deletePlaylistButton.click();

        WebElement notification = driver.findElement(By.cssSelector("div[class='success show']"));
        Assert.assertTrue(notification.isDisplayed());

    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "").substring(0,5);
    }

}

