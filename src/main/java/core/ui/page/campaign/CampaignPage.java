package core.ui.page.campaign;

import core.ui.page.UnbxdCommonPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static lib.constants.UnbxdErrorConstants.PAGE_LOAD_FAILURE;


public class CampaignPage extends UnbxdCommonPage {


    public static String editCampaign=".edit-rule .row .unx-pen-btn";



    @FindBy(xpath = "//a[contains(@class,'unx-close-campaign-flow')]")
    public FluentWebElement campaignWindowClose;


    @FindBy(xpath = "//a[contains(@class,'close pull-right')]")
    public FluentWebElement campaignCloseButton;


    @FindBy(xpath = "//a[contains(@class,'unx-back-link')]")
    public FluentWebElement queryRulesPageFromCampaigns;

    @FindBy(xpath = "//div[contains(@class,'unx-grid')]")
    public FluentList<FluentWebElement> campaigns;

    @FindBy(xpath="//i[contains(@class,'preview-icon')]")
    public FluentWebElement previewCampaignButton;


    public void isAt()
    {
        Assert.assertTrue(title().contains("Campaigns"),PAGE_LOAD_FAILURE);
    }



}
