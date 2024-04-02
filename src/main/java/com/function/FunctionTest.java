package com.function;

import java.util.function.*;

public class FunctionTest {

    private static final Function<Integer,Integer> add5 = i-> i+5;
    private static final Function<Integer,Integer> prod5 = i-> i*5;
    private static final Function<Integer,Integer> addAndProd = i->(i+5)*5;

    private static final Function<String, Integer> len = l -> l.length();
    private static final Function<Integer,Integer> id = Function.identity();
    private static final UnaryOperator<Integer> addUnary = u -> u+5;

    private static final BiFunction<Integer,Integer,Integer> sum = (a,b) -> a+b;
    private static final DoubleFunction<String> doubleToString = d->String.valueOf(d);


    public static void main(String[] args) {
//        System.out.println(add5.apply(10));
//        System.out.println(prod5.apply(100));
        System.out.println(add5.andThen(prod5).apply(100));
//        System.out.println(addAndProd.apply(50));
        System.out.println(len.apply("Harry Potter"));
        System.out.println(len.andThen(add5).apply("Hermione Granger"));
        System.out.println(id.apply(7));
        System.out.println(addUnary.apply(6));
        System.out.println(sum.apply(6, 4));
        System.out.println(doubleToString.apply(12.344));

    }
}
