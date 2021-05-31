package core.ui.frontendui.page;

import core.ui.page.UiBase;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortBy_Page extends UiBase {

    //Sort options
    @FindBy(xpath ="(//div[@class='pricing']/p[@class='price']) |" +
            "//*[@class='actual-price price']//following::*[@itemprop='price'] |" +
            "//*[@class='price ']")
    public FluentList<FluentWebElement> Pricetag;

    @FindBy(xpath ="(//div[@class='pricing']/p[@class='price']) |" +
            "//*[@class='actual-price price']//following::*[@itemprop='price'] |" +
            "//*[@class='price ']")
    public FluentWebElement pricetag;

    @FindBy(xpath = "//*[@class='title']")
    public FluentList<FluentWebElement> eleTitles_Sort;

    @FindBy(xpath = "//*[@class='title']")
    public FluentWebElement eleTitle;

    @FindBy(xpath = "//*[@class='select-box'][1] | //*[@id='sort']")
    public FluentWebElement selectitem;

    //fetch the sort options
    public WebElement sort_option(int i) {
        //return getDriver().findElement(By.cssSelector("select.sort:nth-child(1) option:nth-child("+i+")"));
        return getDriver().findElement(By.cssSelector("div.select-box:nth-child(2) ul:nth-child(2)>li:nth-child("+i+")"));
   }


//    @FindBy(css = ".select-box")
//    public FluentWebElement sortDD;
//
//    @FindBy(css = ".select-box.open ul > li")
//    public FluentList<FluentWebElement> sortDDList;

//    @FindBy(xpath = "//*[@id='catalog-entry-list-sort']")
//  public FluentWebElement sortDD;
//
//    @FindBy(xpath = "//*[@id='catalog-entry-list-sort']//*[@value]")
//    public FluentList<FluentWebElement> sortDDList;

//    @FindBy(css = ".sort")
//    public FluentWebElement sortDD;
//
//    @FindBy(css = ".sort.open ul > li")
//    public FluentList<FluentWebElement> sortDDList;

//    @FindBy(xpath="(//*[@class='select-box'])[1] | //*[@id='sort']")
//    public FluentWebElement sortDD;








}