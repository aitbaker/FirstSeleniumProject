package com.ait.herokuapp.tests;

import com.herokuapp.pages.BrokenImagePage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImageTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBrokenImage();
    }

    @Test
    public void checkBrokenImageTest() {
        new BrokenImagePage(driver).defineLinksOfImages()
                .checkImagesIsBroken();
    }
}
