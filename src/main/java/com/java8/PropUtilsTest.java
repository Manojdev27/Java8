package com.java8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;

public class PropUtilsTest {

    private static BiConsumer<Object, Object> biConsumer = (k,v) -> System.out.println(k+":"+v);

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\Selenium Projects\\java8Features\\src\\test\\resources\\config\\config.properties"));
        for(Map.Entry<Object,Object> entry: properties.entrySet())
        {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }

//        properties.forEach((k,v)-> System.out.println(k+":"+v));
properties.forEach(biConsumer);
        properties.entrySet().forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Harry");
        map.put(2,"Potter");
        map.put(3,"Hermione");
        map.put(4,"Granger");

        for(Map.Entry<Integer,String> temp: map.entrySet()){
            System.out.println(temp.getKey()+":"+temp.getValue());
        }

        map.forEach((k,v) -> System.out.println(k+":"+v));
        System.out.println("keyset");
        map.keySet().forEach(k-> System.out.println(k+":"+map.get(k)));
}
}
