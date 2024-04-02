package com.lambda;

@FunctionalInterface
public interface FuncInterface<T,U,R> {

//    public void print(String a);

//    public void print(String a, String b);

//    public String print();

//    public String print(String a);

//    public Boolean print(String a);

//    public boolean print(int a);

//    public void print(T t);// accepts one parameter and return nothing

    public abstract R someName(T t, U u); // accepts two parameters and returns boolean
}
