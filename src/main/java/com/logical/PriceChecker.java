package com.logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PriceChecker {
    public static void main(String[] args) {
        List<String> product = Arrays.asList("rice", "wheat", "test");
        List<Float> productPrice = Arrays.asList(10.59f, 15.25f, 10.59f);
        List<String> productSold = Arrays.asList("rice", "rice", "wheat", "maggi");
        List<Float> soldPrice = Arrays.asList(10.59f, 15.25f, 15.25f, 1f);
        System.out.println("##### " + priceCheker(product, productPrice, productSold, soldPrice));

    }

    private static int priceCheker(List<String> product, List<Float> productPrice, List<String> productSold,
            List<Float> soldPrice) {

        Map<String, Float> validProducts = product.stream().filter(item -> productSold.contains(item))
                .collect(Collectors.toMap(item -> item, item -> productPrice.get(product.indexOf(item))));

        AtomicInteger i = new AtomicInteger(-1);

        return (int) productSold
                .stream()
                .filter(soldProductName -> {
                    i.addAndGet(1);
                    return validProducts.get(soldProductName) == null
                            || validProducts.get(soldProductName).compareTo(soldPrice.get(i.get())) != 0;
                }).count();
    }

    public static int getCount() {
        List<String> product = new ArrayList<>();
        List<Integer> price = new ArrayList<>();
        List<String> sellProduct = new ArrayList<>();
        List<Integer> soldPrice = new ArrayList<>();
        product.add("Pulses");
        product.add("Maggie");
        product.add("Dove");
        product.add("Eggs");
        price.add(10);
        price.add(20);
        price.add(30);
        price.add(10);
        sellProduct.add("Pulses");
        sellProduct.add("Pulses");
        sellProduct.add("Dove");
        sellProduct.add("Wheat");
        soldPrice.add(10);
        soldPrice.add(20);
        soldPrice.add(10);
        soldPrice.add(10);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < product.size(); i++) {
            map.put(product.get(i), price.get(i));
        }
        int count = 0;
        for (int j = 0; j < sellProduct.size(); j++) {
            if (soldPrice.get(j) != map.get(sellProduct.get(j)))
                count++;
        }
        System.out.println(count);
        return count;
    }

}
