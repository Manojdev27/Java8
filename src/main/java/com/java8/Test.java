package com.java8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");


        System.out.println("Java Method");
        List<WebElement> list = driver.findElements(By.xpath("//a"));
        List<String> text = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i).getText();
            if(!temp.isBlank()){
                text.add(temp);
            }
        }

        for (int i = 0; i < text.size(); i++) {

            System.out.println(text.get(i));

        }

        List<String> listAfterRemovingDuplicates = new ArrayList<>(new HashSet<String>(text));
        Collections.sort(listAfterRemovingDuplicates);
        for (int i = 0; i < listAfterRemovingDuplicates.size(); i++) {
            if(listAfterRemovingDuplicates.get(i).startsWith("C") && listAfterRemovingDuplicates.get(i).startsWith("D")){
                System.out.println(listAfterRemovingDuplicates.get(i));
            }

        }
        driver.quit();
    }
}
