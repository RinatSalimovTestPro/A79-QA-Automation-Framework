package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.BaseTest;

public class Hooks extends BaseTest{
    @Before
    public void setUp() throws Exception {
        launchBrowser("https://qa.koel.app/");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
