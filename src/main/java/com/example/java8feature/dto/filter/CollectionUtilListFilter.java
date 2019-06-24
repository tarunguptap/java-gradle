package com.example.java8feature.dto.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.example.java8feature.dto.filter.ActionBean.Action;

public class CollectionUtilListFilter {

    public static void main(String[] args) {
        // filterCase1();
        filterCase2();
    }

    public static void filterCase1() {
        List<Action> filterActionList = Arrays.asList(Action.SHRINK_RECEIPT, Action.TEST);

        List<ActionBean> availableActions = new ArrayList<>();
        ActionBean w1 = new ActionBean();
        w1.setAction(Action.RECEIVED);
        ActionBean w2 = new ActionBean();
        w2.setAction(Action.SHRINK_RECEIPT);
        availableActions.add(w1);
        availableActions.add(w2);
        // If we use the lambda expression stream, we have to collect the filtered results in the different list, it
        // doesn't reflects in same list
        List<ActionBean> availableActions1 = availableActions.stream()
                .filter(p -> filterActionList.contains(p.getAction())).collect(Collectors.toList());
        System.out.println(availableActions1.size());
        System.out.println(availableActions1.get(0).getAction().toString());

        // using lambda instead of anonymous class

        CollectionUtils.filter(availableActions, obj -> {
            ActionBean actionBean = (ActionBean) obj;
            if (filterActionList.contains(actionBean.getAction())) {
                return true;
            }
            return false;
        });
        System.out.println(availableActions.size());
        System.out.println(availableActions.get(0).getAction().toString());

        // Traditional way of doing the filter using anonymous class
        CollectionUtils.filter(availableActions, new Predicate() {
            @Override
            public boolean evaluate(Object obj) {
                ActionBean actionBean = (ActionBean) obj;
                if (filterActionList.contains(actionBean.getAction())) {
                    return false;
                }
                return true;
            }
        });
    }

    public static void filterCase2() {
        List<Long> lst = new ArrayList<Long>();
        lst.add(1L);
        lst.add(2L);
        /*
         * CollectionUtils.filter(lst, obj -> { if (obj.equals(1L)) { return false; } return true; });
         */
        lst.removeIf(obj -> obj.equals(1L));
        System.out.println(lst);
    }
}
