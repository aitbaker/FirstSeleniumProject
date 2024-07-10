package com.herokuapp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BrokenImagePage extends BasePage{

    public BrokenImagePage(WebDriver driver) {
        super(driver);
    }

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagePage defineLinksOfImages() {
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);
        }
        return this;
    }

    @FindBy(css = "img:nth-child(2)")
    WebElement image1;

    @FindBy(css = "img:nth-child(3)")
    WebElement image2;

    @FindBy(css = "img:nth-child(4)")
    WebElement image3;

    public BrokenImagePage checkImagesIsBroken() {
        softAssert.assertTrue(checkImage(image1));
        softAssert.assertTrue(checkImage(image2));
        softAssert.assertTrue(checkImage(image3));
        softAssert.assertAll();
        return this;
    }

    public boolean checkImage(WebElement image) {
        return (Boolean)((JavascriptExecutor)driver)
                .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);
    }
}
