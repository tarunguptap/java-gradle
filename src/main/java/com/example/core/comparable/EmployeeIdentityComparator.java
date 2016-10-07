package com.example.core.comparable;

import java.io.Serializable;
import java.util.Comparator;

//companycategorycomparator
public class EmployeeIdentityComparator implements Comparator<EmployeeIdentity>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(EmployeeIdentity o1, EmployeeIdentity o2) {
        return o1.getIdentity().compareTo(o2.getIdentity());
    }
}
