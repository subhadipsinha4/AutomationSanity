package core.ui.frontendui.actions;

import core.ui.frontendui.page.Pagination_Page;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class Pagination_SiteActions extends Pagination_Page {
    SoftAssert softAssert = new SoftAssert();

    //Function to verify pagination by clicking on the page number
    public void verify_pagination1(String pUrl) throws InterruptedException {
        System.out.println(pUrl);
        System.out.println("#Function to verify pagination by clicking on the page number.");
        System.out.println("Page - " + page_selected.getText() +  " Selected");
        //System.out.println(PeginationList.size());
        Boolean page_obj = checkElementPresence(page_selected);
        if (page_obj == true) {
            int ncount=product_Titles.size();
            System.out.println("No ofProduct count "+ncount);
            for(int i = 0; i<ncount; i++)
            {
                String Titles=product_Titles.get(i).getText();
                System.out.println("\npage1_Titles "+(i+1)+" : "+Titles);
            }
            System.out.println("---------------------Page 2 navigation------------------------");
            PeginationList.get(1).click();
            Thread.sleep(4000);
            String page_num = page_selected.getText();
            try {
                softAssert.assertTrue((page_num!="1"), "Page2 not selected, pagination test failed!!");
                softAssert.assertAll();
            } catch (AssertionError e) {
                e.printStackTrace();
            }
            System.out.println("Page - " + page_selected.getText() + " Selected");
            System.out.println("No ofProduct count "+ncount);
            for(int i = 0; i<ncount; i++) {
                String Titles = product_Titles.get(i).getText();
                System.out.println("\npage2_Titles "+(i+1)+" : "+Titles);
            }
        } else
            System.out.println("Search item does not contain pagination");
    }



  /* //Function to verify pagination by clicking on the next and previous page icons.
    public void verify_pagination_PreviousNext() throws InterruptedException {
        System.out.println("------------------pagination by clicking on the next and previous page icons---------------------");
        click(page_previous);
        Thread.sleep(2000);
        System.out.println("Page - " + page_selected.getText() + " Selected");
        Boolean page_obj = checkElementPresence(page_selected);
        if (page_obj == true) {

            //-----------Verify previous hidden for Page1---------
            try {
                softAssert.assertFalse(page_previous == null, "Previous icon is displayed for Page1");
                softAssert.assertAll();
            } catch (AssertionError e) {
                e.printStackTrace();
            }
            System.out.println("Previous icon is not displayed");

            //------------Next page navigation---------------------
            click(page_next);
            Thread.sleep(3000);
            String page_num = page_selected.getText();
            try {
                softAssert.assertTrue(page_num.contains("2"), "Page2 not selected, next page navigation test failed!!");
                softAssert.assertAll();
            } catch (AssertionError e) {
                e.printStackTrace();
            }
            System.out.println("Page - "+page_selected.getText()+" Selected");

            //--------------Verify previous icon visible------------
            try {
                softAssert.assertTrue(page_previous.isEnabled(), "Previous icon is not displayed.");
                softAssert.assertAll();
            } catch(AssertionError e) {
                e.printStackTrace();
            }
            System.out.println("Previous icon is displayed");

            //-------------Previous page navigation------------------
            click(page_previous);
            Thread.sleep(3000);
            String page_num1 = page_selected.getText();
            try {
                softAssert.assertTrue(page_num1.contains("1"), "Page1 not selected, previous page navigation test failed!!");
                softAssert.assertAll();
            } catch(AssertionError e) {
                e.printStackTrace();
            }
            System.out.println("Page - "+page_selected.getText()+" Selected");
            System.out.println("Pagination by clicking on the next and previous page icons test passed!");
        } else System.out.println("Search item does not contain pagination");
    } */
}