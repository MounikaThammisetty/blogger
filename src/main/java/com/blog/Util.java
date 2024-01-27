package com.blog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10, 5, 20, 2);
        List<Integer> newData = data.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(newData);
    }
}
