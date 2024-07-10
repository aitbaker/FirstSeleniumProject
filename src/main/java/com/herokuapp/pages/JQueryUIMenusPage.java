package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

public class JQueryUIMenusPage extends BasePage{

    public JQueryUIMenusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ui-id-3")
    WebElement enabled;

    @FindBy(id = "ui-id-4")
    WebElement download;

    public JQueryUIMenusPage hoverEnabled() {
        new Actions(driver).moveToElement(enabled).perform();
        pause(1000);
        return this;
    }

    public JQueryUIMenusPage hoverDownloads() {
        new Actions(driver).moveToElement(download).perform();
        pause(1000);
        return this;
    }

    @FindBy(id = "ui-id-5")
    WebElement pdf;

    @FindBy(id = "ui-id-6")
    WebElement csv;

    @FindBy(id = "ui-id-7")
    WebElement exel;

    public JQueryUIMenusPage clickPdf() {
        click(pdf);
        return this;
    }

    public JQueryUIMenusPage clickCsv() {
        click(csv);
        return this;
    }

    public JQueryUIMenusPage clickExel() {
        click(exel);
        return this;
    }

    public JQueryUIMenusPage checkFileDownloaded(String path, String name) {
        pause(2000);
        Assert.assertTrue(isFileDownloaded(path,name));
        pause(1000);
        return null;
    }

    public boolean isFileDownloaded(String path, String name) {
        File dir = new File(path);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public JQueryUIMenusPage removeDownloadedFile(String path, String name) {
        pause(2000);
        File dir = new File(path);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(name)) {
                dirContents[i].delete();
                return this;
            }
        }
        return this;
    }
}
