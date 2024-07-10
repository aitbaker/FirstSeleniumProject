package com.ait.demoshop.tests;

import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail("*********")
                .setPassword("********"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isUserEmailPresent("neuer1439@gm.com"));
    }
}
