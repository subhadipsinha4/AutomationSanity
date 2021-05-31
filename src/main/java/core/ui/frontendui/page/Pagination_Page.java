package core.ui.frontendui.page;

import core.ui.frontendui.actions.Facet_SiteActions;
import core.ui.page.UiBase;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pagination_Page extends UiBase {

    //pagination
    @FindBy(xpath ="//*[@id='paging']//following::*[@type='button'] |(//*[@class='items pages-items']//*[@class='item'])")
    public FluentList<FluentWebElement> PeginationList;

    @FindBy(xpath = "//nav[@id='paging']//button[@class='sel'] |//*[@class='page undefined'] |//span[@class='pagination-link']")
    public FluentWebElement page_selected;

    @FindBy(xpath ="//div[@class='info']//a[@class='title'] | //*[@class='product-item-link']")
    public FluentList<FluentWebElement> product_Titles;

    @FindBy(xpath = "//nav[@id='paging']//button[@class='prev-next' and @data-page='1']")
    public FluentWebElement page_previous;

    @FindBy(xpath = "//*[@id='paging']//following::*[@class='prev-next' and @data-page='2']")
    public FluentWebElement page_next;

}