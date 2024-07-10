package com.herokuapp.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BasePage {

    WebDriver driver;

    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean isElementPresent(List<WebElement> element) {
        return element.size() > 0;
    }

    public void mouseEvent(int x, int y) {
        Dimension dimension = driver.manage().window().getSize();
        int xOffset = dimension.getWidth() / x;
        int yOffset = dimension.getHeight() / y;

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.mouseMove(xOffset, -yOffset);
    }

    public void verifyLinks(String linkUrl) {

        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + "-" + connection.getResponseMessage() + " link is broken");

            } else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + "-" + e.getMessage() + " - Error occurred");
        }
    }

}
