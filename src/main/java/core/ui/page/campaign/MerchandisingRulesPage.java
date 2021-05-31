package core.ui.page.campaign;

import lib.enums.UnbxdEnum;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MerchandisingRulesPage extends CampaignCreationPage{


    public static final String ruleGroups=".rule-group .unx-rule";
    public static final String ruleGroupHeader=".rule-group .unx-group-header";
    public static final String addRule=".unx-add-rule-plus";
    public static final String  checkMarker=".unx-pen-btn";
    public static final String editOpen=".unx-pen-btn";
    public static final String groupName=".unx-group-name";



    public static final String pinInput=".unx-pos-pin .unx-input-box";
    public static final String pinProductButton=".unx-pin-btn";
    public static final String pinnedProduct="div.pinned";

    public static final String checkPinProduct=".unx-check-pin";
    public static final String checkSlot=".unx-check-slot";

    public static final String attribute="li.unx-attribute ";
    public static final String comparator="li.unx-comparator";
    public static final String valueOfAttribute="li.unx-value";

    public static final String editRule=".unx-pen-btn";
    public static final String removeRule=".unx-remove-rule";

    public static final String slotStartRange=".unx-slot-start-position";
    public static final String slotEndRange=".unx-slot-end-position";




    public static final String conditionList=".Select-menu-outer .Select-option";

    @FindBy(css = "ul.fields-for-preview")
    public FluentWebElement previewFieldElement;

    @FindBy(css=".product-listing header.title span")
    public FluentWebElement productCount;

    @FindBy(xpath = "//a[contains(@class,'unx') and contains(@class,'tab')]")
    public FluentList<FluentWebElement> merchandisingSections;

    @FindBy(xpath = "//div[contains(@class,'unx-filter-group')]")
    public FluentList<FluentWebElement> filterGroups;


    @FindBy(xpath = "//div[contains(@class,'unx-sort-group')]")
    public FluentList<FluentWebElement> sortGroups;


    @FindBy(xpath = "//div[contains(@class,'unx-slot-group')]")
    public FluentList<FluentWebElement> slotGroups;

    @FindBy(xpath = "//div[contains(@class,'unx-boost-group')]")
    public FluentList<FluentWebElement> boostGroups;

    @FindBy(css = "a#action-add-group")
    public FluentWebElement addNewGroup;

    @FindBy(css = ".unx-product-items .unx-pos-pin")
    public FluentList<FluentWebElement> pinProductList;

    @FindBy(css = ".unx-product-item .unx-thumbnail")
    public FluentList<FluentWebElement> productsInPreview;

    @FindBy(css = ".more-products-in-row ")
    public FluentList<FluentWebElement> productsInPreviewMerchandising;


    @FindBy(css = ".facets-tab-icon")
    public FluentWebElement facetTab;


    @FindBy(xpath="//div[contains(@class,'boost-rule')]")
    public FluentWebElement boostSlider;

    @FindBy(xpath="//li[contains(@class,'unx-attribute')]//span")
    public FluentWebElement disabledAttribute;

    @FindBy(xpath = "//li[contains(@class,'unx-comparator')]//span")
    public FluentWebElement disabledComparator;

    @FindBy(xpath = "//li[contains(@class,'unx-value')]//span")
    public FluentWebElement disabledValue;

    @FindBy(xpath = "//input[contains(@class,'unx-slot-start-position')]")
    public FluentWebElement slotRangeStart;

    @FindBy(xpath = "//input[contains(@class,'unx-slot-end-position')]")
    public FluentWebElement slotRangeEnd;

    @FindBy(xpath = "//button[contains(@class,'unx-pin-btn')]")
    public FluentWebElement productPinButton;

    @FindBy(xpath = "//div[contains(@class,'unx-pos-pin')]//input[contains(@class,'unx-input-box')]")
    public FluentWebElement productPinInput;



}
