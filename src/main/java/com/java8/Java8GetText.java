package com.java8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java8GetText {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");

        System.out.println("Java 1.8 method");

        driver.findElements(By.xpath("//a"))
                .stream()
                .map(ele -> ele.getText()).filter(s-> !s.isBlank())
                .sorted()
                .filter(s-> {
                    return s.startsWith("C") || s.startsWith("D");
                })
                .forEach(System.out::println);

        driver.quit();

    }
}
