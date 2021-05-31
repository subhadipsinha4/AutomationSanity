package core.ui.frontendui.actions;

import core.ui.frontendui.page.SitePage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

import java.util.ArrayList;
import java.util.List;

public class SiteActions extends SitePage {


    public SiteActions goToWebsite(String url)
    {
        getDriver().navigate().to(url);
        //goTo(this);
        awaitForPageToLoad();
        return this;
    }

    /*public String getUrl() {
        return WebsiteUrls.GROCERY.getUrlPath();
    }*/

    /*public void searchAction(FluentWebElement Search)
    {
        awaitForElementPresence(Search);
        click(Search);
        await();
    }*/

    public void searchQuery(String query,FluentWebElement searchBox)
    {
        awaitForElementPresence(searchBox);
        click(searchBox);
        searchBox.clear();
        searchBox.fill().with(query);
        click(searchBox);
        await();
    }

    public void fetch_Query(String query,FluentWebElement searchBox)
    {
        awaitForElementPresence(searchBox);
        click(searchBox);
        searchBox.clear();
        searchBox.fill().with(query);
        await();
        searchBox.submit();
        await();
    }
        public List<String> verifySuggestions(FluentList<FluentWebElement> suggestions)
    {
        awaitForElementPresence(autoSuggest);
       /* if(awaitForElementNotDisplayed(autoSuggest))
        {
            System.out.println("Suggestions are not coming");
            return Collections.emptyList();
        }*/
        List<String> values = new ArrayList<>();
        for(int i=0;i<suggestions.size();i++)
        {
            if(suggestions.get(i).isDisplayed()) {
                String autoSuggest = suggestions.get(i).getTextContent();
                values.add(autoSuggest);
            }
        }
        return values;
    }

   public List<String> getSuggestionListInLowerCase(List<String> suggestions)
    {
        List<String> value = new ArrayList<>();

        for(String suggestion : suggestions)
        {
            value.add(suggestion.toLowerCase());
        }
        return value;
    }
}
