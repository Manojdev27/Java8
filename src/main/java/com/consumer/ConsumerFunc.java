package com.consumer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunc {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Harry", "Potter","God hand");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for(String temp : list){
            System.out.println(temp);
        }

        // printing using Java 8 Consumer functional interface
        Consumer<String> consumer = (s) -> System.out.println(s); //string or superclass of string class
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        Consumer<String> consumer2 = (s) -> System.out.println(s.toLowerCase());
        Consumer<String> consumer3 = (s) -> System.out.println(s.startsWith("H"));
        list.forEach(consumer.andThen(consumer1).andThen(consumer2));
        list.forEach(consumer3);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
//        for (int i = 0; i< elements.size();i++){
//            System.out.println(elements.get(i).getText());
//        }

//        Consumer<WebElement> webElementConsumer = (e) -> System.out.println(e.getText());
        Consumer<WebElement> webElementConsumer1 = (e) -> {
            if(e.getText().isBlank()){
                System.out.println(e.getText());
            }

        };
        Consumer<WebElement> webElementConsumer2 = (e) -> {
            if(e.getText().startsWith("Y")){
                System.out.println(e.getText());
            }
        };
        elements.forEach(webElementConsumer2);
        driver.quit();





    }
}
