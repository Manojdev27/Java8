package com.predicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Runner {

    Predicate<Integer> isEven = i-> i%2 == 0;
    Predicate<Integer> isOdd = i-> i%2 == 1;
    Predicate<Integer> isDivBy3 = i -> i%3 == 0;
    Predicate<Integer> isDivBy6 = isEven.and(isDivBy3);

    Predicate<String> isStartsWithA = s -> s.startsWith("A");
    Predicate<String> isStartsWithH = s -> s.startsWith("H");
    Predicate<String> getIsStartsWithAOrStartsWithH = isStartsWithA.or(isStartsWithH);

    Predicate<String> isStartsWithAOrStartsWithH = isStartsWithA.and(isStartsWithH);

    BiPredicate<String,String> isLength = (a,b)->a.length()==b.length();


    @Test
    public void predicateTest(){
        System.out.println(STR."isOdd.test() = \{isOdd.test(9)}");
        System.out.println(STR."isEven.test(10) = \{isEven.test(10)}");
        System.out.println(STR."isDivBy3.test(27) = \{isDivBy3.test(27)}");
        System.out.println(STR."isDivBy6.test(42) = \{isDivBy6.test(42)}");
        System.out.println(STR."getIsStartsWithAOrStartsWithH.test(\"Harry\") = \{getIsStartsWithAOrStartsWithH.test("Harry")}");
        System.out.println(STR."isStartsWithAOrStartsWithH.test(\"Harry\") = \{isStartsWithAOrStartsWithH.test("Harry")}");
        System.out.println(STR."isLength.test(\"Harry\",\"Albus\") = \{isLength.test("Harry", "Albus")}");
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
sum(numbers);
//sumUsingJava8(numbers);
sumUsingJava8(numbers, i->i%2==0);//sum of even numbers in list
sumUsingJava8(numbers, i->i%2==1); // sum of all odd numbers in a list
sumUsingJava8(numbers, i->i%3!=0);
    }

    private void sumUsingJava8(List<Integer> numbers, Predicate<Integer> predicate){
        System.out.println(
                numbers.stream()
                        .filter(predicate)
                        .reduce(0, Integer::sum));
    }

    private void sum(List<Integer> numbers){
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println("sum = " + sum);
    }
}
