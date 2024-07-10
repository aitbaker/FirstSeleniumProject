package com.demoshop.fw;

import com.demoshop.models.Guest;
import com.demoshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegistrationForm(Guest guest) {
        type(By.id("FirstName"), guest.getName());
        type(By.id("LastName"), guest.getLastName());
        type(By.id("Email"), guest.getEmail());
        type(By.id("Password"), guest.getPassword());
        type(By.id("ConfirmPassword"), guest.getConfirmationPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean IsExistedUserErrorPresent() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }

    public boolean isUserEmailPresent(String userEmail) {
        return isTextPresent
                (By.cssSelector(".header-links-wrapper:nth-child(2) [href='/customer/info']"), userEmail);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }
}
