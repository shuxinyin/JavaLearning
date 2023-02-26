package com.learn.array_;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        Integer[] newArray = Arrays.copyOf(array, 3);
        System.out.println(Arrays.toString(newArray));

    }
}
