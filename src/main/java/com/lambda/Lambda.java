package com.lambda;

import com.anonymousinnerclass.Iprintable;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {

        // Functional programming - Lamdba expression
        //1. parameter the abstract method and your lambda expression
        //2. return type
        //3. Only one abstract or unimplemented methods
        // the above 3 conditions will satisfy then will use the lambda expression.
        Iprintable obj2 = () -> System.out.println("This is from lambda expression");
        obj2.print();

          // Method accepts one parameter and return nothing - consumer
//        FuncInterface anonymousClass = (String s) -> System.out.println(s);
//        anonymousClass.print("Harry");

        // Method accepts one parameter and return nothing - consumer
//        FuncInterface anonymousClass = (String s, String str) -> System.out.println(s +" "+ str);
//        anonymousClass.print("Harry", "Potter");

        // Method does not accepts any parameters and return something - supplier
//        FuncInterface anonymousClass = () -> "Harry";
//        System.out.println(anonymousClass.print());

        // Method accepts one parameter and return something - Function
//        FuncInterface anonymousClass = s -> s.toLowerCase();
//        System.out.println(anonymousClass.print("HARRY"));

//        FuncInterface anonymousClass = s1 -> s1.length()>0;
//        System.out.println(anonymousClass1.print("Harry Potter"));

//        FuncInterface anonymousClass = s1 ->s1>10;
//        System.out.println(anonymousClass.print(7));

        // accepts one parameter and return nothing using Generics
//        FuncInterface<String> obj = (a) -> System.out.println(a);
//        obj.print("Harry");
//
//        FuncInterface<Integer> obj1 = (a) -> System.out.println(a);
//        obj1.print(7);
//
//        List<String> list = new ArrayList<>();

        FuncInterface<String, String, String> obj3 = (a,b)-> a+b;
        System.out.println(obj3.someName("Harry", "Potter"));

        FuncInterface<Integer, Integer, Integer> obj4 = (a,b)-> a+b;
        System.out.println(obj4.someName(10,15));


    }
}

