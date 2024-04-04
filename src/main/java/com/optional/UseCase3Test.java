package com.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UseCase3Test {

    @Test
    public void testOptionalInGetters(){
        Pers pers = Pers.builder().build();
        System.out.println(pers.getFirstName());

    }
}
