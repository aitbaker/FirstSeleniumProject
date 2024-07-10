package com.ait.demoshop.tests;

import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutLink();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail("neuer1439@gm.com")
                .setPassword("Neuer1234"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCartPositiveTest() {

        app.getItem().clickOnAddToCartButton();
        app.getItem().clickOnShoppingCartLink();
        Assert.assertTrue(app.getItem().isItemNameEqual("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition() {
        app.getItem().removeItemFromCart();
    }
}
