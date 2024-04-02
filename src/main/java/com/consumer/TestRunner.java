package com.consumer;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class TestRunner {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
//        selectValueFromDropDown(element,"Magenta", "text");
        selectFromDropDown(e->e.selectByVisibleText("Magenta"),element);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
//        selectValueFromDropDown(element,"1","value");
        selectFromDropDown(e->e.selectByValue("1"),element);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
//        selectValueFromDropDown(element,"3","index");
        selectFromDropDown(e->e.selectByIndex(3),element);

        List<WebElement> list = new Select(driver.findElement(By.id("cars"))).getOptions();
        list.stream().skip(2).forEach(e->e.click());
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();

    }

    private static void selectFromDropDown(Consumer<Select> consumer, WebElement element){
        consumer.accept(new Select(element));
    }
    private static void selectValueFromDropDown(WebElement element, String textorvalueorindex, String strategy){
        Select select = new Select(element);
        if(strategy.equalsIgnoreCase("text")){
            select.selectByVisibleText(textorvalueorindex);
        } else if (strategy.equalsIgnoreCase("value")) {
            select.selectByValue(textorvalueorindex);
        } else if (strategy.equalsIgnoreCase("index")) {
            select.selectByIndex(Integer.parseInt(textorvalueorindex));
        }else {
            System.out.println("Invalid Strategy");
        }

    }
}
