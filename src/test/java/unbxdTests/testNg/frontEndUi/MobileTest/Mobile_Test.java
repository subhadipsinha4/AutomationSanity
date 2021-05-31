package unbxdTests.testNg.frontEndUi.MobileTest;

import core.ui.frontendui.actions.Search_SiteActions;
import lib.Helper;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import unbxdTests.testNg.ui.BaseTest;

import java.util.HashMap;


public class Mobile_Test extends BaseTest{
    @Page
    Search_SiteActions search_SiteActions;

    @BeforeClass
    public void init()
    {
        HashMap<String,String> mobileEmulation = new HashMap<String,String>();
        mobileEmulation.put("deviceName", "iPhone X");
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        System.setProperty("webdriver.chrome.driver","./src/main/resources/driver/chromedriver2.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.Globalindustrial.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void search_filter(String url, String query) throws InterruptedException {
//        search_SiteActions.goToWebsite(url);
//        maximizeWindow();
//        search_SiteActions.HandleRandomPopup(url);
//        search_SiteActions.search_Query(query, search_SiteActions.searchBox);
//        await();
//        search_SiteActions.HandleRandomPopup(url);
//        search_SiteActions.Fetch_Result(url);
//
   }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        Helper.tearDown();
    }
}
