package com.example.firstapp;
import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands (String color)
    {
        List<String> brands = new ArrayList<>();
        if(color.equals("Amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else if (color.equals("Light")) {
            brands.add("Jali Pale Ale");
            brands.add("Gout Scott");
        } else {
            brands.add("some beer 1 ");
            brands.add("some beer 2");

        }
        return brands;
    }
}
