package com.example.java8feature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.BooleanUtils;

public class Test1 {
    public static void main(String[] args) {
        String[] values = { "TARUN1", "ARUN1", "TARUN2" };

        Map<String, String> map = new HashMap<>();
        map.put("TARUN", "YES");
        map.put("ARUN", "ARUN");

        String key = "TARUN";

        boolean exists = map.containsKey(key) && Arrays.asList(values).contains(map.get(key));

        System.out.println(exists);

        System.out.println(toBoolean(StringUtils.defaultIfEmpty((String) map.get("TARUN1"), "UNVERIFIED"), "YES",
                "UNVERIFIED"));

    }

    public static Boolean isValidResponse(Map<String, String> information, String questionCode, String validResponses) {
        String questionResponse = information.get(questionCode);
        if (StringUtils.isNotBlank(questionResponse) && StringUtils.split(validResponses, ",").length > 0
                && Arrays.asList(validResponses).contains(questionResponse)) {
            return true;
        }
        return false;
    }

    public static boolean toBoolean(String str, String trueString, String falseString) {
        try {
            return BooleanUtils.toBoolean(str, trueString, falseString);
        } catch (RuntimeException runtimeException) {
            return false;
        }
    }

    boolean isSecondaryAdjustmentReasonseForLowerGradeProvided(Map information) {
        String[] secondaryAdjustmentReasonForLowerGrade = { "TARUN1", "ARUN1" };
        return Arrays.stream(secondaryAdjustmentReasonForLowerGrade).anyMatch(information::containsKey);

    }

}
