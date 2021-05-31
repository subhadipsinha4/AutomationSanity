package unbxdTests.testNg.ui;

import org.fluentlenium.core.FluentAdapter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import lib.BrowserInitializer;
import lib.EnvironmentConfig;

public class BaseTest extends FluentAdapter {


    public  WebDriver driver=null;
    public final String testDataPath="src/test/resources/testData/";




    public void  setUp() {
        try {
            BrowserInitializer initializer = new BrowserInitializer();
            initializer.init();
            driver = initializer.getDriver();
        }
        catch(Exception e)
        {
            System.out.println("Browser Initialization is failed with Exception "+e.getMessage());
        }
    }


    @AfterClass(alwaysRun = true)
    public void removeContextForTest()
    {
        EnvironmentConfig.unSetContext();
    }

}
