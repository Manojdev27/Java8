package com.tests;

import com.factory.LocatorFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorStrategyTest {

    private By hamburgerMenu =  By.id("nav-hamburger-menu");
    private By menuitem = By.xpath("//div[text() ='%s']/parent::a");

    @Test
    public void locatorStrategyTest(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        click(driver,hamburgerMenu);
//        clickUsingJava8(driver, "xpath", String.format(String.valueOf(menuitem), "Best Sellers"));
//        clickUsingJava8(driver, "xpath", String.format(menuitem, "Best Sellers"));
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].click();",element);
    }

    public void click(ChromeDriver driver, By by){
        driver.findElement(by).click();
    }

    public void clickUsingJava8(ChromeDriver driver,String locator, String value){
       By by = LocatorFactory.getByLocator("xpath",value);
       click(driver,by);
    }
//    public void click(ChromeDriver driver, String locator, String value){
//        if(locator.equalsIgnoreCase("id")){
//            driver.findElement(By.id(value)).click();
//        } else if (locator.equalsIgnoreCase("xpath")) {
//            driver.findElement(By.xpath(value)).click();
//        } else if (locator.equalsIgnoreCase("name")) {
//            driver.findElement(By.name(value)).click();
//        }else {
//            throw new RuntimeException("Locator Strategy not found");
//        }
//    }
}
