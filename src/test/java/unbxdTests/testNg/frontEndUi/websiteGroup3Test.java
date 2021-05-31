package unbxdTests.testNg.frontEndUi;

import core.ui.frontendui.actions.SiteActions;
import lib.Helper;
import lib.annotation.FileToTest;
import org.fluentlenium.core.annotation.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import unbxdTests.testNg.ui.BaseTest;

import java.util.List;

public class websiteGroup3Test extends BaseTest{

    @Page
    SiteActions siteActions;

    @BeforeClass
    public void init() {
        super.setUp();
        initFluent(driver);
        initTest();
    }

    @FileToTest(value = "/frontEndTestData/suggestionVerificationGroup3Urls.json")
    @Test(description = "autoSuggest verification ",dataProviderClass = WebsiteGroup1Test.class, dataProvider = "getUrl")
    public void verifySuggestionsTest(String url, String query) {
        SoftAssert softAssert = new SoftAssert();
        String queryValue = query.toLowerCase();

        siteActions.goToWebsite(url);
        siteActions.searchQuery(query, siteActions.group3SearchBox);

        List<String> suggestions = siteActions.verifySuggestions(siteActions.suggestions);
        List<String> popularProducts = siteActions.verifySuggestions(siteActions.popularProduct);

        if(suggestions.size()==0 && popularProducts.size()==0)
            Assert.fail("Suggestions are not coming for"+url);


        List<String> suggestionInLowerCase= siteActions.getSuggestionListInLowerCase(suggestions);
        for(String value:suggestionInLowerCase)
        {
            softAssert.assertTrue(value.contains(queryValue),"sitename:"+url+ "===> value :"+value+"doest not contain " +queryValue);
        }

        List<String> popularProductInLoweCase= siteActions.getSuggestionListInLowerCase(popularProducts);
        for(String popularProduct:popularProductInLoweCase)
        {
            softAssert.assertTrue(popularProduct.contains(queryValue),"sitename:"+url+ "===> popularProduct :"+popularProduct+" doest not contain "+ queryValue);
        }
        softAssert.assertAll();
    }

    @FileToTest(value = "/frontEndTestData/websiteGroup3Url.json")
    @Test(description = "Verifies autosuggest is coming or not",dataProviderClass = WebsiteGroup1Test.class, dataProvider = "getUrl")
    public void verifyAutoSuggestPresenceTest(String url, String query)
    {
        siteActions.goToWebsite(url);
        siteActions.searchQuery(query, siteActions.group3SearchBox);
        List<String> suggestions = siteActions.verifySuggestions(siteActions.suggestions);
        List<String> popularProducts = siteActions.verifySuggestions(siteActions.popularProduct);

        if(suggestions.size()==0 && popularProducts.size()==0)
            Assert.fail("Suggestions are not coming for"+url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
        Helper.tearDown();
    }

}
