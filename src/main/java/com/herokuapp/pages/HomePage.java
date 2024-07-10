package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li:nth-child(4)>a")
    WebElement brokenImage;

    public BrokenImagePage getBrokenImage() {
        click(brokenImage);
        return new BrokenImagePage(driver);
    }

    @FindBy(css = "li:nth-child(28)>a")
    WebElement jQueryUIMenus;

    public JQueryUIMenusPage getJQueryMenusUI() {
        click(jQueryUIMenus);
        return new JQueryUIMenusPage(driver);
    }

    @FindBy(css = "li:nth-child(2)>a")
    WebElement addRemoveElements;

    public AddRemoveElementsPage getAddRemoveElements() {
        click(addRemoveElements);
        return new AddRemoveElementsPage(driver);
    }
}
