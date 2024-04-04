package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionWebElementTest {

    private By menuitems = By.xpath("//div[@id='nav-xshop']/a");

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        List<WebElement> elements = driver.findElements(menuitems);

//        List<String> textFromWebElements = getTextNameFromWebElements(elements);
//        List<String> href = getAttributeFromWebElements(elements, "href");
//        List<String> tagNameFromWebElements = getTagNameFromWebElements(elements);

//        textFromWebElements.forEach(System.out::println);
//        href.forEach(System.out::println);
//        tagNameFromWebElements.forEach(System.out::println);

        List<String> getText = getDesiredValueUsingJava8(elements,WebElement::getText);
        List<String> href = getDesiredValueUsingJava8(elements,e-> e.getAttribute("href"));
        List<String> getTagName = getDesiredValueUsingJava8(elements, WebElement::getTagName);

        getText.forEach(System.out::println);
        href.forEach(System.out::println);
        getTagName.forEach(System.out::println);

        driver.quit();
    }

    private List<String> getDesiredValueUsingJava8(List<WebElement> elements, Function<WebElement,String> function){
        return elements.stream().map(function).collect(Collectors.toList());
    }

    private List<String> getTagNameFromWebElements(List<WebElement> elements){
        List<String> strings = new ArrayList<>();
        for(WebElement element:elements){
            strings.add(element.getTagName());
        }
        return strings;
    }

    private List<String> getTextNameFromWebElements(List<WebElement> elements) {
        List<String> strings = new ArrayList<>();
        for (WebElement element : elements) {
            strings.add(element.getText());
        }
        return strings;
    }
        private List<String> getAttributeFromWebElements(List<WebElement> elements,String attribute) {
            List<String> strings = new ArrayList<>();
            for (WebElement element : elements) {
                strings.add(element.getAttribute(attribute));
            }
            return strings;
        }


}
