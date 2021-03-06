package com.example.java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;

public class Test {

    public static void main(String[] args) {

        if (getStringOptional().isPresent()) {
            System.out.println("Optional not empty" + getStringOptional().get());
        } else {
            System.out.println("Optional empty");
        }

        List<String> l1 = new ArrayList<>();
        l1.add("ITEM_NUMBER");
        l1.add("ITEM_TYPE");

        List<String> l2 = new ArrayList<>();
        l2.add("ITEM_MANUFACTURER");
        l2.add("ITEM_MATERIAL");

        List<String>[] arrayOfList = new List[2];
        arrayOfList[0] = l1;
        arrayOfList[1] = l2;

        for (int i = 0; i < arrayOfList.length; i++) {
            List<String> l = arrayOfList[i];
            System.out.println(l);
        }
    }

    private static Optional<String> getStringOptional() {
        List<String> stringList = new ArrayList<String>();
        System.out.println("@@@@@@@@@@@@@@ is collection empty @@@@@@@@@@@@" + CollectionUtils.isEmpty(stringList));
        System.out.println("@@@@@@ 1111 " + stringList.stream().findFirst().orElse(null));

        System.out.println("@@@@@@ 1.1 " + stringList.stream().findFirst());

        List<String> stringList1 = Arrays.asList("1", "2");
        System.out.println("@@@@@@ 2222 " + stringList1.stream().findFirst().orElse(null));
        System.out.println("@@@@@@ 2222.1 " + stringList1.stream().findFirst().get());

        if (CollectionUtils.isNotEmpty(stringList)) {
            return Optional.ofNullable(stringList.get(0));
        }
        return Optional.empty();
    }

}
