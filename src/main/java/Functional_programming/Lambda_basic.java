package Functional_programming;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda_basic {
    public static void main(String[] args){
        String[] array=new String[]{ "apple", "Orange", "banana", "Lemon" };
        Arrays.sort(array, Comparator.comparing(String::toLowerCase));
        System.out.println(String.join(",",array));
    }

}
