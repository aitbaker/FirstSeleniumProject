package com.ait.demoshop.tests;

import com.demoshop.fw.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite(enabled = true)
    public void tearDown(){
        app.stop();
    }
}
