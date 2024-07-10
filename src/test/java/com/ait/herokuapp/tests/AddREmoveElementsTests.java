package com.ait.herokuapp.tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTests extends TestBase{

    HomePage home;
    AddRemoveElementsPage addRemove;

    @BeforeMethod
    public void precondition() {
        home = new HomePage(driver);
        addRemove = new AddRemoveElementsPage(driver);
        home.getAddRemoveElements();
    }

    @Test
    public void addElementsTest() {
        addRemove.addElements()
                .verifyAddElements();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void removeElementsTest() {
        addRemove.removeElements()
                .verifyRemoveElements();
    }

}
