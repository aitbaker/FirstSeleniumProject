package com.ait.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JQueryUIMenusPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryMenusTests extends TestBase{

    HomePage home;
    JQueryUIMenusPage jQuery;
    String path = "C:/Users/paxpi/Downloads";

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        jQuery = new JQueryUIMenusPage(driver);
        home.getJQueryMenusUI();
    }

    @Test
    public void jQueryUIMenusPdfTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickPdf()
                .checkFileDownloaded(path,"menu.pdf");
    }

    @Test
    public void jQueryUIMenusCsvTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickCsv()
                .checkFileDownloaded(path,"menu.csv");
    }

    @Test
    public void jQueryUIMenusExelTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickExel()
                .checkFileDownloaded(path,"menu.xls");
    }

    @AfterMethod
    public void postCondition() {
        jQuery.removeDownloadedFile(path,"menu");
    }
}
