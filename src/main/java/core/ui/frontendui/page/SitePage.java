package core.ui.frontendui.page;


import core.ui.page.UiBase;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayDeque;

public class SitePage extends UiBase {


    @FindBy(xpath = "//input[contains(@unbxdattr,'sq')]")
    public FluentWebElement group2searchBox;

    @FindBy(xpath = "//input[contains(@data-unbxdattr,'sq')]")
    public FluentWebElement group1SearchBox;

    @FindBy(xpath = "//input[contains(@id,'search')]")
    public FluentWebElement group3SearchBox;

    @FindBy(xpath = "//div[contains(@class,'unbxd-as-wrapper')]//li[contains(@class,'unbxd-as-popular-product')]")
    public FluentList<FluentWebElement> popularProduct;

    @FindBy(xpath = "//li[contains(@class,'unbxd-as-keyandinsuggestion')]")
    public FluentWebElement keyWordSuggestion;

    @FindBy(xpath = "//div[contains(@class,'unbxd-as-wrapper')]//li[contains(@class,'unbxd-as-keysuggestion')]")
    public FluentList<FluentWebElement> suggestions;

    @FindBy(xpath = "//div[contains(@class,'unbxd-as-wrapper')]")
    public FluentWebElement autoSuggest;

}