package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
       driver = new ChromeDriver();

        // driver.get("https://telranedu.web.app/login");
        driver.navigate().to("https://telranedu.web.app/login");// with history
       //maximize browser window
        driver.manage().window().maximize();
    }

    @Test
    public void findElementByTagName() {
        //find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        //find list of elements
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        //find element by class name
        WebElement element1 = driver.findElement(By.className("navbar-component_nav__1X_4m"));
        System.out.println(element1.getText());

        //find element by name
        WebElement email = driver.findElement(By.name("email"));

        String inputText = email.getAttribute("name");
        System.out.println("!!!! " +inputText);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
