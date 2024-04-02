package com.supplier;



import com.aventstack.extentreports.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Supplier;

public class SupplierTest {

    // Supplier takes no arguments and return something
    private Supplier<Double> supplier = () -> Math.random();
    private Supplier<String> stringSupplier = () -> "Hello World";


    @Test
    public void test1(){
        System.out.println(supplier.get());
        System.out.println(stringSupplier.get());
    }

    @Test
    public void test2(){
        Assertions.assertEquals(1,2,"failed - custom message");
        Assertions.assertEquals(1,0,() -> "failed - custom message");
    }
    public String getHelloWorld(){
        return "Hello World";
    }

    private static boolean compute(Supplier<Boolean> even, Supplier<Boolean> divisibleBy10){
        return even.get()&& divisibleBy10.get();
    }

    private static boolean isDivisibleBy10(int i){
        System.out.println("in div by 10 method");
        return i%10 == 0;
    }

    private static boolean isEven(int i){
        System.out.println("in div by 2 method");
        return i%2 == 0;
    }

//    Supplier is lazily evaluates
    public static void main(String[] args) {
        System.out.println(compute(() -> isEven(6), ()->isDivisibleBy10(14)));

        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.google.co.in/");

        new WebDriverWait(driver,10)
                .withMessage(() ->"Custom Message")
                .until(ExpectedConditions.elementToBeClickable(By.name("q12"))).sendKeys("Harry Potter");
        driver.quit();
    }

}
