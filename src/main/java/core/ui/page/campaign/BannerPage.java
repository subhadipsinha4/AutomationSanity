package core.ui.page.campaign;

import core.ui.page.UnbxdCommonPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

public class BannerPage  extends CampaignCreationPage{


    @FindBy(xpath = "//div[contains(@class,'unx-url-section')]//input[contains(@class,'unx-radio')]")
    public FluentWebElement imageUrlRadioButton;

    @FindBy(xpath = "//div[contains(@class,'unx-url-section')]//input[contains(@class,'unx-inputbox' ) and position()=2]")
    public FluentWebElement imageUrlInput;

    @FindBy(xpath = "//div[contains(@class,'unx-url-section')]//input[contains(@class,'unx-inputbox' ) and position()=1]")
    public FluentWebElement landingPageUrlInput;

    @FindBy(xpath = "//div[contains(@class,'unx-html-section')]//input[contains(@class,'unx-radio')]")
    public FluentWebElement htmlBannerRadioButton;

    @FindBy(xpath = "//div[contains(@class,'unx-html-section')]//textarea[contains(@class,'unx-textarea')]")
    public FluentWebElement htmlBannerInput;

    @FindBy(xpath = "//div[contains(@class,'unx-html-section')]//span[contains(@class,'unx-trash-btn')]")
    public FluentWebElement htmlBannerDeleteButton;

    @FindBy(xpath = "//div[contains(@class,'unx-url-section')]//span[contains(@class,'unx-trash-btn')]")
    public FluentWebElement imageBannerDeleteButton;

    @FindBy(xpath = "//div[contains(@class,'unx-url-section')]")
    public FluentWebElement imageBannerSection;

    @FindBy(xpath = "//div[contains(@class,'unx-html-section')]")
    public FluentWebElement htmlBannerSection;

    @FindBy(xpath = "//a[contains(@class,'unx-close-campaign-flow')]")
    public FluentWebElement closeCampaignFlow;





}
