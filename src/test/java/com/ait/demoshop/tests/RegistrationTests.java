package com.ait.demoshop.tests;

import com.demoshop.models.Guest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @Test
    public void createAccountPositiveTest() {

        int i = new Random().nextInt(1000) + 1000;

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegistrationForm(new Guest()
                .setName("Manu")
                .setLastName("Neuer")
                .setEmail("neuer"+ i + "@gm.com")
                .setPassword("Neuer1234")
                .setConfirmationPassword("Neuer1234"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLogoutLinkPresent());
    }

    @Test
    public void createExistedAccountNegativeTest() {

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegistrationForm(new Guest()
                .setName("Manu")
                .setLastName("Neuer")
                .setEmail("neuer@gm.com")
                .setPassword("Neuer1234")
                .setConfirmationPassword("Neuer1234"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().IsExistedUserErrorPresent());
    }
}
