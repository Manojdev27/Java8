package com.anonymousinnerclass;

public class ConsolePrinterImpl implements Iprintable{


    @Override
    public void print() {
        System.out.println("printing on the consoles");
    }
}
