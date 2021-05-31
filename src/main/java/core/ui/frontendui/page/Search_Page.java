package core.ui.frontendui.page;

import core.ui.page.UiBase;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_Page extends UiBase {

    @FindBy(xpath = "(//input[contains(@autocomplete,'off') and contains(@type,'text') or contains(@type,'search')])[1]")
    public  FluentWebElement searchBox;

    //Entire search Msg xpath
    @FindBy(xpath = "//*[@id='unbxd_searchresults_msg'] |" +
            " //*[@class='candara large fleft unbxd_search_heading']//following::span[@data-unbxd-selector='search-msg'] | " +
            "(//*[@id='left-nav']//following::*[@class='results-count-info']) | " +
            "//*[@class='base']")
    public FluentWebElement SearchMsg;

    // invalid msg xpath
    @FindBy(xpath = "//*[@id='unbxd_no_results_text'] | //*[@class='unbxd_no_results_text'] | (//*[@class='not-found']//following::p)[1]")
    public FluentWebElement NoSearchMsg;

    //search result xpath
    @FindBy(xpath = "//*[@class='candara large fleft unbxd_search_heading']//following::span[@id='searchReults'] | //*[@id='unbxd_searchresults_msg']//*[3] | (//*[@id='left-nav']//following::span)[1] |(//*[@class='toolbar-number'])[3]")
    public FluentWebElement SearchResult;

    //popup Boscovs
    @FindBy(xpath = "//*[@id='monetate_email_lightbox']//following::a[@href='#close'] ")
    public FluentWebElement monetateEmailPopup;

    //facet_click xpath
    @FindBy(xpath = "(//*[@id='category_uFilter']//following::*[contains(@id,'category_uFilter')])[1] | (//*[@id='v_OrigCat_uFilter']//following::*[contains(@id,'v_OrigCat_uFilter')])[1] | (//*[@class='search-facet'])[1] |(//*[@data-filter='category-filter']//following::*[@class='count'])[1]")
    public FluentWebElement filter_facet;

    @FindBy(xpath = "//*[@class='unbxd_selected_facets'] | //*[@class='facet_reset'] | (//*[@class='clear-all'])[1]")
    public FluentWebElement filterAppliedMsg;

    @FindBy(xpath = "(//*[@class='search-facet']//preceding-sibling::h2)[1] |(//*[@data-filter='category-filter']//preceding-sibling::*[@class='name'])[1]")
    public FluentWebElement facet_name;

    @FindBy(xpath ="//*[@class='selection']")
    public FluentWebElement FacetName_verify;


}