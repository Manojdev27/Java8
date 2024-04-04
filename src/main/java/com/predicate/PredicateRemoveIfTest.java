package com.predicate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateRemoveIfTest {

    @Test
    public void PredicateTest(){
        Predicate<Integer> isOdd = i->i%2!=1;
        Predicate<Integer> isDivisibleBy3 = i->i%3==0;
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        System.out.println(STR."integers = \{integers}");
        integers.removeIf(isOdd);
//        integers.removeIf(isDivisibleBy3);
        System.out.println(STR."integers = \{integers}");

        Predicate<Integer> isEven = i->i%2==0;
        List<Integer> evenNumber = manipulateNumber(numbers,isEven);
        List<Integer> oddNumber = manipulateNumber(numbers,isEven.negate());
        System.out.println(STR."oddNumber = \{oddNumber}");
        System.out.println(STR."evenNumber = \{evenNumber}");
        Map<Boolean,List<Integer>> booleanListMap = partitionBasedOnRule(numbers,isEven);
        System.out.println(STR."booleanListMap.get(true) = \{booleanListMap.get(true)}");
        System.out.println(STR."booleanListMap.get(false) = \{booleanListMap.get(false)}");
    }

    private Map<Boolean, List<Integer>> partitionBasedOnRule(List<Integer> numbers, Predicate<Integer> rule) {
        return numbers.stream().parallel().collect(Collectors.partitioningBy(rule));
    }

    private static List<Integer> manipulateNumber(List<Integer> numbers, Predicate<Integer> rule){
        return numbers.stream().parallel().filter(rule).collect(Collectors.toList());
}

}
