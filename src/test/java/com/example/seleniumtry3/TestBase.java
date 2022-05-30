package com.example.seleniumtry3;

public class TestBase {
}

//package io.automatenow.tests;
//
//        import io.automatenow.pages.*;
//        import org.testng.Assert;
//        import org.testng.annotations.*;

//
//public class TestBase extends BasePage {
//    protected NavigationBar navBar;
//    protected HomePage homePage;
//    protected SandboxPage sandboxPage;
//
//
//    @BeforeMethod(alwaysRun = true)
//    @Parameters("browser")
//    public void setup(@Optional("chrome") String browser) {
//        navBar = new NavigationBar();
//        homePage = new HomePage();
//        sandboxPage = new SandboxPage();
//
//        Assert.assertTrue(goToHomepage(browser), "An error occurred while navigating to the homepage");
//    }
//
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        closeBrowser();
//    }
//}