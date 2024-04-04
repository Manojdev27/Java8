package com.optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Optional;

public class OptionalUseCaseTest {
WebDriver driver;
    @Test
    public void testOptional(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("alert('Welcome to Guru99');");


        Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver))
                .ifPresent(Alert::accept);


    }
}
