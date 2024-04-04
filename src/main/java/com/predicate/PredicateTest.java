package com.predicate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    @Test
    public void webElementPredicateTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
        clickAnElementMatching(elements, e->e.getText().equalsIgnoreCase("Mobiles"));
//        clickAnElementMatching(elements, e->e.getAttribute("href").equalsIgnoreCase("Mobiles"));
//        clickAnElementMatching(elements, e->e.getTagName().equalsIgnoreCase("Mobiles"));
    }

    private void clickAnElementMatching(List<WebElement> elements, Predicate<WebElement> condition) {
//        for (int i = 0; i < elements.size() ; i++) {
//            if(elements.get(i).getText().equalsIgnoreCase(menuitem)){
//                elements.get(i).click();
//                break;
//            }

       WebElement element = elements
               .stream()
               .parallel()
               .filter(condition)
                .findFirst()
               .orElseThrow(() -> new RuntimeException("Element with text"));
        element.click();

        }
    }
