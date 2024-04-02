package com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnarayOperatorDemo {

    @Test
    public void unaryOperatorDemo() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Harry Potter");
        arrayList.add("Hermione Granger");
        arrayList.add("Ronald Weasley");
        arrayList.add("Nevile Longbottom");
        arrayList.add("Albus Dumbledore");

        // convert string to uppercase
//        List<String> strings = new ArrayList<>();
//        for(String temp: arrayList){
//            System.out.println(temp.toUpperCase());
//        }
//        strings.forEach(System.out::println);
//    }

        // using Java 8 convert String to uppercase
        arrayList.replaceAll(String::toUpperCase);
        arrayList.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(integers.parallelStream().mapToInt(Integer::intValue).sum());
        System.out.println(integers.parallelStream().reduce(0, (a,b) -> a+b));
        System.out.println(integers.parallelStream().reduce(0, Integer::sum));

    }


}
