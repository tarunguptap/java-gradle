package com.example.java8feature.dto.complex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class client {
    public static void main(String[] args) {
        List<ObjectResponse> objectResponses = ObjectResponseInitializerHelper.getObjectResponseList();

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map = CommonUtils.collectionToStream(objectResponses)
                .filter(objectResponse -> Objects.nonNull(objectResponse.getObjectQuestionResponse()))
                // .map(ObjectResponse::getObjectQuestionResponse)
                .collect(
                        Collectors.toMap(objectResponse -> objectResponse.getObjectQuestionResponse()
                                .getObjectQuestion().getObjectCode(), objectResponse -> objectResponse
                                .getObjectQuestionResponse().getResponse()));

        System.out.println(map);

        CommonUtils
                .collectionToStream(objectResponses)
                .filter(objectResponse -> Objects.nonNull(objectResponse.getObjectQuestionResponse()))
                .forEach(
                        objectResponse -> {
                            map1.put(objectResponse.getObjectQuestionResponse().getObjectQuestion().getObjectCode(),
                                    objectResponse.getObjectQuestionResponse().getResponse());

                            if (CollectionUtils.isNotEmpty(objectResponse.getObjectAddressSet())) {
                                objectResponse.getObjectAddressSet().forEach(objectAddress -> {
                                    map1.put(objectAddress.getAddressType(), objectAddress.getAddressName());
                                });
                            }
                        });

        System.out.println(map1);

    }
}
