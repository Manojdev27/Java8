package com.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional(){
//        String name = null;
//        System.out.println(name.startsWith("H"));
//        Optional<String> optionalString = Optional.ofNullable(null);
//        System.out.println(optionalString.get());

        String browser = System.getenv("browser");
        if(browser==null){
            browser = "chrome";
        }else{

        }
       String browser1 = Optional.ofNullable(System.getenv("browser")).orElse("chrome");
        System.out.println("browser1 = " + browser1);

        Optional.ofNullable(System.getenv("browser")).orElseGet(this::getDefaultBrowser);
        Optional.ofNullable(System.getenv("browser")).ifPresent(System.out::println);
        Optional.ofNullable(System.getenv("browser"))
                .ifPresentOrElse(System.out::println,() -> System.out.println("it is not present"));
//        Optional.ofNullable(System.getenv("browser"))
//                .orElseThrow(IllegalAccessException::new);
    }

    public String getDefaultBrowser(){
        return "chrome";
    }
}
