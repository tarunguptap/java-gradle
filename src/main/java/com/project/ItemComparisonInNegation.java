package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;

public class ItemComparisonInNegation {
    public static void main(String[] args) {
        List<Long> itemIds = new ArrayList<>(Arrays.asList(111L, 112L, 113L, 114L));

        // Case 1 : itemId is null
        System.out.println("Case 1 validate : " + validate(itemIds, null));
        System.out.println("Case 1 validate_refactored : " + validate_refactored(itemIds, null));
        System.out.println("Case 1 validate_refactored_new : " + validate_refactored_new(itemIds, null));

        // Case 2 : itemId is blank
        System.out.println("Case 2 validate : " + validate(new ArrayList<>(), 111L));
        System.out.println("Case 2 validate_refactored : " + validate_refactored(new ArrayList<>(), 111L));
        System.out.println("Case 2 validate_refactored_new : " + validate_refactored_new(new ArrayList<>(), 111L));

        // Case 3 : itemId doesn't contained in itemIds List and has size greater than 1
        System.out.println("Case 3 validate : " + validate(itemIds, 115L));
        System.out.println("Case 3 validate_refactored : " + validate_refactored(itemIds, 115L));
        System.out.println("Case 3 validate_refactored_new : " + validate_refactored_new(itemIds, 115L));

        // Case 4 : itemId contained in itemIds List and has size greater than 1
        System.out.println("Case 4 validate : " + validate(itemIds, 114L));
        System.out.println("Case 4 validate_refactored : " + validate_refactored(itemIds, 114L));
        System.out.println("Case 4 validate_refactored_new : " + validate_refactored_new(itemIds, 114L));

        itemIds = new ArrayList<>(Arrays.asList(115L));

        // Case 4 : itemId doesn't contained in itemIds List and has size = 1
        System.out.println("Case 5 validate : " + validate(itemIds, 116L));
        System.out.println("Case 5 validate_refactored : " + validate_refactored(itemIds, 116L));
        System.out.println("Case 5 validate_refactored_new : " + validate_refactored_new(itemIds, 116L));

        // Case 6 : itemId contained in itemIds List and has size = 1
        System.out.println("Case 6 validate : " + validate(itemIds, 115L));
        System.out.println("Case 6 validate_refactored : " + validate_refactored(itemIds, 115L));
        System.out.println("Case 6 validate_refactored_new : " + validate_refactored_new(itemIds, 115L));

    }

    private static boolean validate(List<Long> itemIds, Long itemId) {
        if (!itemIds.isEmpty() && itemId != null) {
            if (itemIds.size() > 1
                    || (itemIds.size() == 1 && itemIds.iterator().next().longValue() != itemId.longValue())) {
                return false;
            }
            return true;
        }
        if (!itemIds.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean validate_refactored(List<Long> itemIds, Long itemId) {
        if (CollectionUtils.isNotEmpty(itemIds)) {
            /*
             * In case of bulk trade item will be null so the below condition will be true. if any item already
             * exists in the system with the entered IMEI/ESN number.
             */
            if (Objects.isNull(itemId)) {
                return false;
            } else {
                return !(itemIds.size() > 1 || (itemIds.size() == 1 && itemIds.iterator().next().longValue() != itemId
                        .longValue()));
            }
        }
        return true;
    }

    private static boolean validate_refactored_new(List<Long> itemIds, Long itemId) {
        /*
         * In case of bulk trade item will be null so the below condition will be true. if any item already
         * exists in the system with the entered IMEI/ESN number.
         */
        if (CollectionUtils.size(itemIds) > 0 && Objects.isNull(itemId)) {
            return false;
        } else {
            return CollectionUtils.size(itemIds) == 0 || (itemIds.size() == 1 && itemIds.get(0).equals(itemId));
        }
    }
}
