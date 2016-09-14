package com.example.java8feature;

import java.util.List;
import java.util.stream.Collectors;

import com.example.java8feature.dto.InitializerHelper;

public class filterlist {

    public List<Long> getIdListFromObjectList() {
        List<Long> ids = InitializerHelper.getCustomerList().stream().map(customer -> customer.getId())
                .collect(Collectors.toList());
        System.out.println(ids);
        return ids;
    }

    public static void main(String[] args) {
        filterlist fl = new filterlist();
        fl.getIdListFromObjectList();
    }

}
