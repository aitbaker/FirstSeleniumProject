package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
       driver = new ChromeDriver();
       driver.get("https://www.google.com");
    }

    //tests
    @Test
    public void findElementByTagName() {
        System.out.println("Site opened!!!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
        driver.quit();// all tabs & close browser
        // driver.close(); only one tab(if tab only one -> close browser)
    }
}
