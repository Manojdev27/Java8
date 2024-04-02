package com;

import java.util.function.Consumer;

public class TestRunner {

    static void perform(Animal animal){
        animal.run();
    }

    public static void main(String[] args) {
        perform(new Dog());
//        Animal animal = () -> System.out.println("Running at 100kmph");
        perform(() -> System.out.println("Running at 100kmph"));
//        toLower("HARRY");
//        toUpper("harry");

        stringOperation((s) -> System.out.println(s.toLowerCase()),  "HARRY");
        stringOperation((s) -> System.out.println(s.toUpperCase()),  "harry");
        stringOperation((s) -> System.out.println(s.equalsIgnoreCase("Harry")), "harry");

    }

    private static void stringOperation(Consumer<String> consumer, String temp){
consumer.accept(temp);
    }
    private static void toLower(String string){
        System.out.println(string.toLowerCase());
    }
    private static void toUpper(String string){
        System.out.println(string.toUpperCase());
    }
}
