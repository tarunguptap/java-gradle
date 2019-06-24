package com.example.java8feature.dto.complex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModelClient {
    public static void main(String[] args) {
        Model ab = new Model("A", "B");
        Model cd = new Model("C", "D");
        Model ef = new Model("E", "F");

        List<Model> modelList = Arrays.asList(ab, cd, ef);

        List<String> resultSet = modelList.stream().flatMap(e -> Stream.of(e.getStringA(), e.getStringB()))
                .collect(Collectors.toList());

        System.out.println(resultSet);
    }
}
