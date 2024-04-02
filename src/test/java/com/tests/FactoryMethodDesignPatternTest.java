package com.tests;

import com.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactoryMethodDesignPatternTest {
    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"chrome"}
        };
    }

    @Test(dataProvider = "getData")
    public void factoryMethodTest(String browser){
        WebDriver driver = DriverFactory.getDriver(BrowserType.CHROME);
        driver.get("https://www.google.co.in/");

    }
}
