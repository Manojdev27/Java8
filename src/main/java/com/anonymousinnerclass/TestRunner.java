package com.anonymousinnerclass;

public class TestRunner {

    public static void main(String[] args) {
        //conventional way
        Iprintable obj = new ConsolePrinterImpl();
        obj.print(); //printing on the consoles

        // Anonymous inner class
        Iprintable iprintable = new Iprintable() {
            @Override
            public void print() {
                System.out.println("From Anonymous inner class");
            }
        };

        Iprintable iprintable2 = new Iprintable() {
            @Override
            public void print() {
                System.out.println("From Anonymous inner class test");

            }
        };
        iprintable.print();
        iprintable2.print();
        iprintable2.scanAsExcel();
        iprintable2.scan();
    }

}
