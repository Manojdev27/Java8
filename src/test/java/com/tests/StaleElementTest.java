package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class StaleElementTest {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

//        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('gLFyf gsfi')[0].remove();");

//        new WebDriverWait(driver,5)
//                .ignoring(SecurityException.class)
//                .until(ExpectedConditions.visibilityOf(element))
//                .sendKeys("Harry Potter");

        new WebDriverWait(driver,5)
                .until(d->{
                    if(!d.findElements(By.name("q")).isEmpty()){
                        return d.findElements(By.name("q")).get(0);
                    }else {
                        System.out.println("Searching to find the element");
                        d.navigate().refresh();
                        return d.findElement(By.name("q"));
                    }

                }).sendKeys("Hermione");


    }
}
