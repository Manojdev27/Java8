package com.optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pers {

    private String firstName;
    private List<String> jobs;
    private FavFoods favFoods;

//    public String getFirstName(){
//        return Optional.ofNullable(firstName).orElse("abcd");
//    }
}
