package core.ui.frontendui.actions;
import core.ui.frontendui.page.Search_Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Search_SiteActions extends Search_Page {

    SoftAssert softAssert = new SoftAssert();

    public Search_SiteActions goToWebsite(String url) {
        getDriver().navigate().to(url);
        //goTo(this);
        awaitForPageToLoad();
        return this;
    }

    public void search_Query(String query, FluentWebElement searchBox) {
        awaitForElementPresence(searchBox);
        click(searchBox);
        searchBox.clear();
        searchBox.fill().with(query);
        await();
        searchBox.submit();
        await();
    }

    public void Fetch_Result(String pUrl) {
        String searchMsg, initSearchResult;
        try {
            awaitForElementPresence(SearchMsg);
            searchMsg = SearchMsg.getText();
            System.out.println(pUrl);
            initSearchResult = SearchResult.getText();
            Assert.assertTrue(awaitForElementPresence(SearchResult));
            int ActualSearchResult = Integer.parseInt(initSearchResult);
            if (ActualSearchResult > 0) {
                System.out.println("\n" + searchMsg);
                System.out.println("We found " + ActualSearchResult);
            } else {
                System.out.println("\nExpected search result not displayed");
                Assert.fail("Expected search result is not displayed!");
            }
        } catch (Exception e) {
            String InvalidSearch = NoSearchMsg.getText();
            System.out.println("InvalidSearch : " + InvalidSearch + "\n");

        }
    }

    public void HandleRandomPopup(String pUrl){
        if(pUrl.contains("https://www.Boscovs.com/")){
            closePopUp();
        }
    }
    public void closePopUp() {
        try {
            if (monetateEmailPopup.isDisplayed()) {
                monetateEmailPopup.click();
            }
        } catch (Exception e) {
        }
    }



    //##### END CODE #####
}