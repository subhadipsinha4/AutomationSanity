package core.ui.frontendui.actions;
import core.ui.frontendui.page.SortBy_Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;

public class SortBy_SiteActions extends SortBy_Page {

    SoftAssert softAssert = new SoftAssert();
    public void selectSortByItem(String pFilter) throws Exception {
        int i=0;
        switch (pFilter){
            case "Top Rated":
                i=1;    break;
            case "Best Selling":
                i=2;    break;
            case "Products A-Z":
                i=3;    break;
            case "Products Z-A":
                i=4;    break;
            case "Price High to Low":
                i=5;    break;
            case "Price Low to High":
                i=6;    break;
        }
        selectitem.click();
        sort_option(i).click();
        Thread.sleep(3000);
    }

//    public void selectSortByItem(String pFilter) throws InterruptedException {
//        FluentWebElement sortDropdown = sortDD;
//        sortDropdown.click();
//        Thread.sleep(2000);
//        for(int i=1; i <= sortDDList.size();i++) {
//            if (sort_option(i).getText().equals(pFilter))
//            {
//                sort_option(i).click();
//                Thread.sleep(3000);
//                break;
//            }
//        }
//    }

    public void SortByHighToLow(String pFilter) throws Exception {
        selectSortByItem(pFilter);
        System.out.println(pFilter);
        awaitForElementPresence(pricetag);
        ArrayList<Float> List = new ArrayList<Float>();
        List = GetPriceList();
        System.out.println("\nHigh To Low: ");
        System.out.println(List);
        for (int j = 0; j < List.size()-1; j++) {
            System.out.println(List.get(j) + " >= " + List.get(j+1));
            if(j!=List.size()-1){
                if(List.get(j) < List.get(j+1)){
                    try {
                        softAssert.assertTrue(List.get(j) >= List.get(j+1), "Sorting High to low failed!! "+List.get(j) + "is not greater than" + List.get(j + 1));
                        softAssert.assertAll();
                    } catch (AssertionError e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void SortByLowToHigh(String pFilter)throws Exception {
        selectSortByItem(pFilter);
        Thread.sleep(2000);
        awaitForElementPresence(pricetag);
        ArrayList<Float> List = new ArrayList<Float>();
        List = GetPriceList();
        System.out.println("\nLow To High: ");
        System.out.println(List);
        for (int j = 0; j < List.size()-1; j++) {
            System.out.println(List.get(j) + " <= " + List.get(j + 1));
            if(j!=List.size()-1){
                if(List.get(j) > List.get(j+1)){
                    try {
                        softAssert.assertTrue(List.get(j) <= List.get(j + 1), "Sorting Low to High failed!!"+List.get(j) +" is not less than " + List.get(j + 1));
                        softAssert.assertAll();
                    } catch (AssertionError e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public ArrayList<Float> GetPriceList() throws Exception {
        awaitForPageToLoad();
        awaitForElementPresence(pricetag);
        String price,getpricetag;
        int ncount=Pricetag.size();
        System.out.println("\nNo of price tags "+ncount);
        ArrayList<Float> GetPriceList = new ArrayList<Float>();
        for(int i = 0; i<ncount; i++)
        {
            price=Pricetag.get(i).getText();
            String tag = price.replace("$", "");
            getpricetag = tag.replace(",", "");
            Float nPriceTag = Float.parseFloat(getpricetag);
            GetPriceList.add(nPriceTag);
        }
        return GetPriceList;
    }

    public void SortTitle_Asc(String pFilter)throws Exception {
        selectSortByItem(pFilter);
        awaitForElementPresence(eleTitle);
        ArrayList<String> Titles = new ArrayList();
        int nCount = eleTitles_Sort.size();
        System.out.println("\nNo of titles displayed " + nCount);
        for (int i = 0; i < nCount; i++) {
            String TitleName = eleTitles_Sort.get(i).getText();
            Titles.add(TitleName);
        }
        ArrayList<String> UItitles = new ArrayList();
        UItitles.addAll(Titles);
        Collections.sort(Titles);
        try {
            System.out.println("Actual list: "+UItitles);
            System.out.println("Sorted list: "+Titles);
            for(int j=0; j<nCount; j++) {
                Assert.assertTrue(Titles.get(j).equals(UItitles.get(j)));
                System.out.println("\n"+Titles.get(j)+" | "+UItitles.get(j) );
            }
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    public void SortTitle_Desc(String pFilter)throws Exception {
        Thread.sleep(2000);
        selectSortByItem(pFilter);
        awaitForElementPresence(eleTitle);
        ArrayList<String> Titles = new ArrayList();
        int nCount = eleTitles_Sort.size();
        System.out.println("\nNo of titles " + nCount);
        for (int i = 0; i < nCount; i++) {
            String TitleName = eleTitles_Sort.get(i).getText();
            Titles.add(TitleName);
        }
        ArrayList<String> UItitles = new ArrayList();
        UItitles.addAll(Titles);
        Collections.sort(Titles, Collections.reverseOrder());
        try {
            System.out.println("Actual list: "+UItitles);
            System.out.println("Sorted list: "+Titles);
            for(int j=0; j<nCount; j++) {
                Assert.assertTrue(UItitles.get(j).equals(Titles.get(j)));
                System.out.println("\n"+Titles.get(j)+" | "+UItitles.get(j) );
            }
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    //##### END CODE #####
}