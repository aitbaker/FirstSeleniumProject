package com.demoshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;
    ItemHelper item;

    public void init() {
        System.err.close();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        item = new ItemHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ItemHelper getItem() {
        return item;
    }

    public void stop() {
        driver.quit();
    }
}
