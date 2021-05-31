package unbxdTests.testNg.frontEndUi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import core.ui.frontendui.actions.SiteActions;
import lib.Helper;
import lib.UnbxdFileUtils;
import lib.annotation.FileToTest;
import org.fluentlenium.core.annotation.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import unbxdTests.testNg.ui.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class WebsiteGroup1Test extends BaseTest{

    @Page
    SiteActions siteActions;

    @BeforeClass
    public void init() {
        super.setUp();
        initFluent(driver);
        initTest();
    }


    @FileToTest(value = "/frontEndTestData/suggestionVerificationGroup1Urls.json")
    @Test(description = "autoSuggest verification ", dataProvider = "getUrl")
    public void verifySuggestionsTest(String url, String query) {
        SoftAssert softAssert = new SoftAssert();
        String queryValue = query.toLowerCase();

        siteActions.goToWebsite(url);
        siteActions.searchQuery(query, siteActions.group1SearchBox);

        List<String> suggestions = siteActions.verifySuggestions(siteActions.suggestions);
        List<String> popularProducts = siteActions.verifySuggestions(siteActions.popularProduct);

        if(suggestions.size()==0 && popularProducts.size()==0)
            Assert.fail("Suggestions are not coming for"+url);


        List<String> suggestionInLowerCase= siteActions.getSuggestionListInLowerCase(suggestions);
        for(String value:suggestionInLowerCase)
        {
            softAssert.assertTrue(value.contains(queryValue),"sitename:"+url+ "===> value :"+value+"doest not contain " +queryValue );
        }

        List<String> popularProductInLoweCase= siteActions.getSuggestionListInLowerCase(popularProducts);
        for(String popularProduct:popularProductInLoweCase)
        {
            softAssert.assertTrue(popularProduct.contains(queryValue),"sitename:"+url+ "===> popularProduct :"+popularProduct+" doest not contain "+ queryValue);
        }
        softAssert.assertAll();
    }


    public void verifyAutoSuggestPresenceTest(String url, String query)
    {
        siteActions.goToWebsite(url);
        siteActions.searchQuery(query, siteActions.group1SearchBox);
        List<String> suggestions = siteActions.verifySuggestions(siteActions.suggestions);
        List<String> popularProducts = siteActions.verifySuggestions(siteActions.popularProduct);
        if(suggestions.size()==0 && popularProducts.size()==0)
            Assert.fail("Suggestions are not coming for"+url);

    }


    private final String testFilePath="target"+ File.separator+"test-classes"+File.separator+"testData"+File.separator;

    @DataProvider(name = "getUrl")
    public Object [] [] getUrls(Method m){
        Object [] [] urls;
        String filePath=(m.getAnnotation(FileToTest.class)).value();
        String fileName = testFilePath+filePath;
        fileName= UnbxdFileUtils.normalizePath(fileName);

        JsonParser parser=new JsonParser();
        int count = 0;
        try {
            List<Object[]> testObjects = new ArrayList<>();
            Object obj = parser.parse(new FileReader(fileName));
            JsonObject object=(JsonObject) obj;
            JsonArray array=object.getAsJsonArray("testData");
            for(int i=0;i<array.size();i++)
            {
                String url  = array.get(i).getAsJsonObject().get("url").getAsString();
                JsonArray array1 = array.get(i).getAsJsonObject().get("queries").getAsJsonArray();
                for(int j = 0 ; j <array1.size(); j++){
                    testObjects.add(new Object[]{url,array1.get(j).getAsString()});
                }
            }
            urls = new Object[testObjects.size()][];
            for(Object testObject : testObjects){
                Object[] object2 = (Object[]) testObject;
                urls[count] = object2;
                count++;

            }

            return urls;
        }

        catch(Exception e)
        {
            e.printStackTrace();

        }
        return new Object[0][0];
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        Helper.tearDown();
    }
}
