package com.example.java8feature.dto.filter;

public class ActionBean {

    public enum Action {
        RECEIVED, SHRINK_RECEIPT, TEST, WIFI;
    }

    private Action action;

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action
     *            the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }
}
