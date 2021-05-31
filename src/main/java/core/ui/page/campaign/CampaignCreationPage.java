package core.ui.page.campaign;

import core.ui.page.UnbxdCommonPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

import static lib.constants.UnbxdErrorConstants.CALENDAR_WINDOW_FAILURE;
import static lib.constants.UnbxdErrorConstants.DELETE_CONFIRMATION_WINDOW_FAILURE;

public class CampaignCreationPage extends UnbxdCommonPage{

    @FindBy(xpath = "//div[contains(@class,'unx-campaign-form')]//input[contains(@class,'unx-enter-campaign-name')]")
    public FluentWebElement campaignNameInput;


    @FindBy(xpath = "//input[contains(@class,'unx-campaign-start-date')]")
    public FluentWebElement campaignStartDate;

    @FindBy(xpath ="//input[contains(@class,'unx-campaign-end-date')]")
    public FluentWebElement campaignEndDate;

    @FindBy(css="#campaign_time_zone_chosen div b")
    public FluentWebElement timeZoneDropDown;

    @FindBy(css = "#campaign_time_zone_chosen .chosen-search input")
    public FluentWebElement timeZoneInput;

    @FindBy(css = "#campaign_time_zone_chosen .chosen-results li")
    public FluentList<FluentWebElement> searchResults;

    @FindBy(css = "#campaign_time_zone_chosen .chosen-results li.highlighted")
    public FluentWebElement highlightedResult;


    @FindBy(xpath = "//label[contains(@class,'unx-desktop ')]")
    public FluentWebElement desktopDevice;

    @FindBy(xpath = "//label[contains(@class,'unx-tablet')]")
    public FluentWebElement tabletDevice;

    @FindBy(xpath = "//label[contains(@class,'unx-mobile')]")
    public FluentWebElement mobileDevice;

    @FindBy(xpath = "//label[contains(@class,'unx-android')]")
    public FluentWebElement androidApp;

    @FindBy(xpath = "//label[contains(@class,'unx-ios')]")
    public FluentWebElement iosApp;

    @FindBy(xpath = "//label[contains(@class,'unx-windows')]")
    public FluentWebElement windowsApp;



    @FindBy(xpath = "//div[contains(@class,'unx-campaign-description')]//textarea")
    public FluentWebElement campaignDescription;





    @FindBy(xpath="//a[contains(@class,'unx-start-merchandize-link')]")
    public FluentWebElement merchandising;

    @FindBy(xpath="//a[contains(@class,'unx-create-landing-link')]")
    public FluentWebElement landingPage;

    @FindBy(xpath="//a[contains(@class,'unx-add-url-btn')]")
    public FluentWebElement redirectUrl;

    @FindBy(xpath = "//a[contains(@class,'unx-redirect-input')]")
    public FluentWebElement redirectUrlInput;

    @FindBy(xpath = "//a[contains(@class,'unx-cancel-url-btn')]")
    public FluentWebElement redirectUrlCancel;


    @FindBy(css=".calendar-table tbody td.available")
    public FluentList<FluentWebElement> days;

    @FindBy(css = "button.applyBtn")
    public FluentWebElement applyCalendar;




    public final static String editCampaign="a i.icon-edit";
    public final static String moreOptions="div.dropdown .more-btn";
    public final static String deleteCampagin=".edit-option a.delete-link-modal";
    public final static String duplicateCampaign="a.unx-delete-link-modal";
    public final static String campaignTitle = ".unx-campaign-name";


    @FindBy(xpath = "//a[contains(@class,'unx-search-box')]//input[contains(@class,unx-input-search)]")
    public FluentWebElement campaignSearch;

    @FindBy(xpath = "//a[contains(@class,'unx-search-box')]//i[contains(@class,unx-open-search)]")
    public FluentWebElement campaignSearchOpen;

    @FindBy(xpath="//a[contains(@class,'unx-zipper-plus-btn')]")
    public FluentWebElement addNewCampaignButton;

    @FindBy(xpath="//div[contains(@class,'unx-grid')]")
    public FluentList<FluentWebElement> campaignList;




    @FindBy(xpath = "//a[contains(@class,'unx-submit-modal')]")
    public FluentWebElement deleteCampaign;



    public void deleteFirstCampaign(String name) {
        threadWait();
        Assert.assertTrue(campaignList.size()>0,"No Campaigns are matching for the Given Name");
        FluentWebElement campaign=campaignList.get(0);

        campaign.findFirst(moreOptions).click();
        campaign.findFirst(deleteCampagin).click();
        Assert.assertTrue(find("body.modal-open").size() > 0, DELETE_CONFIRMATION_WINDOW_FAILURE);
        awaitForElementPresence(deleteCampaign);
        deleteCampaign.click();
        awaitForElementPresence(successMessage);
    }


    public void deleteCampaignByName(String name) {
        Assert.assertTrue(campaignList.size() > 0, "Campaigs are not present for this query");
        FluentWebElement campaign = getCampaignByName(name);
        Assert.assertNotNull(campaign, "No Campaign is present with the name " + name);

        campaign.findFirst(moreOptions).click();
        campaign.findFirst(deleteCampagin).click();
        Assert.assertTrue(find("body.modal-open").size()>0,DELETE_CONFIRMATION_WINDOW_FAILURE);
        awaitForElementPresence(deleteCampaign);
        deleteCampaign.click();
        awaitForElementPresence(successMessage);
    }


    public void selectTimeZone(String timeZone)
    {
        timeZoneDropDown.click();
        Assert.assertTrue(findFirst("#campaign_time_zone_chosen").getAttribute("class").contains("chosen-container-active"),"TimeZone DropDown Window not opening");

        timeZoneInput.fill().with(timeZone);
        highlightedResult.click();
    }

    public void fillDay(String day)
    {
        int startDay= Integer.parseInt(days.get(0).getTextContent().trim());

        if(startDay>Integer.parseInt(day))
        {
            return ;
        }
        for(FluentWebElement eachDay:days)
        {
            if(eachDay.getTextContent().trim()==day)
            {
                eachDay.click();
                break;
            }

        }
    }


    public String fillCampaignData(Map<String,Object> campaignData)
    {
        String campaignName="Auto"+System.currentTimeMillis();
        campaignNameInput.fill().with(campaignName);
        campaignStartDate.click();

        Assert.assertTrue(applyCalendar.isDisplayed(),CALENDAR_WINDOW_FAILURE);
        fillDate((String) campaignData.get("StartDate"));

        if(campaignData.get("endDate")!=null)
            fillDate((String) campaignData.get("endDate"));

        selectTimeZone((String) campaignData.get("timeZone"));

        selectDevices((ArrayList<String>) campaignData.get("devices"));

        campaignDescription.fill().with((String) campaignData.get("CampaignDescription"));

        awaitTillElementDisplayed(nextButton);
        nextButton.click();
        awaitForPageToLoad();

        return campaignName;

    }


    public void selectDevices(ArrayList<String> devices)
    {
        if (devices == null)
            return;
        for(String device:devices)
        {
            if(device.equalsIgnoreCase("Desktop")) {
                desktopDevice.click();
                Assert.assertTrue(desktopDevice.getElement().findElement(By.xpath("../input")).isSelected());
            }
            else if(device.equalsIgnoreCase("Tablet")) {
                tabletDevice.click();
                Assert.assertTrue(tabletDevice.getElement().findElement(By.xpath("../input")).isSelected());
            }
            else if(device.equalsIgnoreCase("Mobile")) {
                mobileDevice.click();
                Assert.assertTrue(mobileDevice.getElement().findElement(By.xpath("../input")).isSelected());
            }
        }
    }

    public void editCampaign(FluentWebElement element) {
        if(element==null) {

            Assert.fail("Campaign Element is null");
        }
        element.findFirst(editCampaign).click();
        awaitForPageToLoad();
        awaitTillElementDisplayed(nextButton);
    }

    public void selectLastCampaign() {
        editCampaign(campaignList.get(campaignList.size() - 1));
    }

    public FluentWebElement getCampaignByName(String name) {
        awaitTillElementDisplayed(addNewCampaignButton);
        for (int i = 0; i < campaignList.size(); i++) {
            if (campaignList.get(i).findFirst(campaignTitle).getText().trim().equalsIgnoreCase(name))
                return campaignList.get(i);
        }
        return null;
    }

    public  void editCampaignName() {
        String campaignName = "Auto" + System.currentTimeMillis();
        campaignNameInput.fill().with(campaignName);
    }

}
