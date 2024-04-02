package com.anonymousinnerclass;

@FunctionalInterface
public interface Iprintable {
    //Functional Interface can have multiple static and default methods
    // It can have only one abstract or unimplemented methods

    public void print();

   default void scan(){
       System.out.println("scanning");
   }
   static void printToConsole(){
       System.out.println("printing the console");
   }

   default void scanAsExcel(){
       System.out.println("Scan as excel");
   }

   static void scanAsPdf(){
       System.out.println("scanning as a pdf");
   }




}
